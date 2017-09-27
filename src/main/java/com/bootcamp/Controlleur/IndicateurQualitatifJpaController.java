/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.IndicateurQualitatif;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Bello
 */
public class IndicateurQualitatifJpaController implements Serializable {

    private EntityManager em = null;

    public IndicateurQualitatifJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouvel indicateur qualitatif
    public void create(IndicateurQualitatif indicateurQualitatif) {
        try {
            em.getTransaction().begin();
            em.persist(indicateurQualitatif);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un indicateur qualitatif
    public void edit(IndicateurQualitatif indicateurQualitatif) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            indicateurQualitatif = em.merge(indicateurQualitatif);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findIndicateurQualitatif(indicateurQualitatif.getId()) == null) {
                    throw new NonexistentEntityException("L'indicateurQualitatif " + indicateurQualitatif.getNom()+ " n'existe plus.");
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
            IndicateurQualitatif indicateurQualitatif;
            try {
                indicateurQualitatif = em.getReference(IndicateurQualitatif.class, id);
                indicateurQualitatif.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("L'indicateurQualitatif with id " + id + " no longer exists.", enfe);
            }
            em.remove(indicateurQualitatif);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<IndicateurQualitatif> findAllIndicateurQualitatifs() {
        try {
            String qlString = "SELECT indicateurQualitatif from IndicateurQualitatif indicateurQualitatif";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public IndicateurQualitatif findIndicateurQualitatif(Long id) {
        try {
            return em.find(IndicateurQualitatif.class, id);
        } finally {
            em.close();
        }
    }
}
