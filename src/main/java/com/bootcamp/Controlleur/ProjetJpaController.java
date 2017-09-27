/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import com.bootcamp.Entites.Projet;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author Bello
 */
public class ProjetJpaController implements Serializable {

    private EntityManager em;
    
    public ProjetJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouveau projet
    public void create(Projet projet) {
        try {
            em.getTransaction().begin();
            em.persist(projet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un projet
    public void edit(Projet projet) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            projet = em.merge(projet);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findProjet(projet.getId()) == null) {
                    throw new NonexistentEntityException("Le projet " + projet.getNom() + " n'existe plus.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        try {
            em.getTransaction().begin();
            Projet projet;
            try {
                projet = em.getReference(Projet.class, id);
                projet.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The projet with id " + id + " no longer exists.", enfe);
            }
            em.remove(projet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<Projet> findAllProjets() {
        try {
            String qlString = "SELECT projet from Projet projet";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public Projet findProjet(Long id) {
        try {
            return em.find(Projet.class, id);
        } finally {
            em.close();
        }
    }
}
