/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.Personne;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Bello
 */
public class PersonneJpaController implements Serializable {

    private EntityManager em;
    
    public PersonneJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer une nouvelle personne
    public void create(Personne personne) {
        try {
            em.getTransaction().begin();
            em.persist(personne);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier une personne
    public void edit(Personne personne) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            personne = em.merge(personne);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findPersonne(personne.getId()) == null) {
                    throw new NonexistentEntityException(personne.getNom() + " n'existe plus.");
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
            Personne personne;
            try {
                personne = em.getReference(Personne.class, id);
                personne.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personne with id " + id + " no longer exists.", enfe);
            }
            em.remove(personne);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<Personne> findAllPersonnes() {
        try {
            String qlString = "SELECT personne from Personne personne";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public Personne findPersonne(Long id) {
        try {
            return em.find(Personne.class, id);
        } finally {
            em.close();
        }
    }
}
