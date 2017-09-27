/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.IndicateurQuantitatif;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Bello
 */
public class IndicateurQuantitatifJpaController implements Serializable {

    private EntityManager em = null;

    public IndicateurQuantitatifJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouvel indicateur quantitatif
    public void create(IndicateurQuantitatif indicateurQuantitatif) {
        try {
            em.getTransaction().begin();
            em.persist(indicateurQuantitatif);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un indicateur quantitatif
    public void edit(IndicateurQuantitatif indicateurQuantitatif) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            indicateurQuantitatif = em.merge(indicateurQuantitatif);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findIndicateurQuantitatif(indicateurQuantitatif.getId()) == null) {
                    throw new NonexistentEntityException("L'indicateurQuantitatif " + indicateurQuantitatif.getNom()+ " n'existe plus.");
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
            IndicateurQuantitatif indicateurQuantitatif;
            try {
                indicateurQuantitatif = em.getReference(IndicateurQuantitatif.class, id);
                indicateurQuantitatif.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("L'indicateurQuantitatif with id " + id + " no longer exists.", enfe);
            }
            em.remove(indicateurQuantitatif);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<IndicateurQuantitatif> findAllIndicateurQuantitatifs() {
        try {
            String qlString = "SELECT indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public IndicateurQuantitatif findIndicateurQuantitatif(Long id) {
        try {
            return em.find(IndicateurQuantitatif.class, id);
        } finally {
            em.close();
        }
    }
}
