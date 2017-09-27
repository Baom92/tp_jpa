/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.Programme;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Bello
 */
public class ProgrammeJpaController implements Serializable {

    private EntityManager em;
    
    public ProgrammeJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouveau programme
    public void create(Programme programme) {
        try {
            em.getTransaction().begin();
            em.persist(programme);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un programme
    public void edit(Programme programme) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            programme = em.merge(programme);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findProgramme(programme.getId()) == null) {
                    throw new NonexistentEntityException("Le programme " + programme.getNom() + " n'existe plus.");
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
            Programme programme;
            try {
                programme = em.getReference(Programme.class, id);
                programme.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The programme with id " + id + " no longer exists.", enfe);
            }
            em.remove(programme);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<Programme> findAllProgrammes() {
        try {
            String qlString = "SELECT programme from Programme programme";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public Programme findProgramme(Long id) {
        try {
            return em.find(Programme.class, id);
        } finally {
            em.close();
        }
    }
}
