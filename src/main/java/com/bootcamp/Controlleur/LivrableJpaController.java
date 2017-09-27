/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.Livrable;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Bello
 */
public class LivrableJpaController implements Serializable {

    private EntityManager em = null;

    public LivrableJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouveau livrable
    public void create(Livrable livrable) {
        try {
            em.getTransaction().begin();
            em.persist(livrable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un livrable
    public void edit(Livrable livrable) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            livrable = em.merge(livrable);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findLivrable(livrable.getId()) == null) {
                    throw new NonexistentEntityException("Le livrable " + livrable.getNom()+ " n'existe plus.");
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
            Livrable livrable;
            try {
                livrable = em.getReference(Livrable.class, id);
                livrable.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Le livrable with id " + id + " no longer exists.", enfe);
            }
            em.remove(livrable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<Livrable> findAllLivrables() {
        try {
            String qlString = "SELECT livrable from Livrable livrable";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public Livrable findLivrable(Long id) {
        try {
            return em.find(Livrable.class, id);
        } finally {
            em.close();
        }
    }
}
