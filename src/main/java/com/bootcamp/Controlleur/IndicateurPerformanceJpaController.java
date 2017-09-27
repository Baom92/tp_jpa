/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.IndicateurPerformance;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Bello
 */
public class IndicateurPerformanceJpaController implements Serializable {

    private EntityManager em = null;

    public IndicateurPerformanceJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouvel indicateur de performance
    public void create(IndicateurPerformance indicateurPerformance) {
        try {
            em.getTransaction().begin();
            em.persist(indicateurPerformance);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un fournisseur
    public void edit(IndicateurPerformance indicateurPerformance) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            indicateurPerformance = em.merge(indicateurPerformance);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findIndicateurPerformance(indicateurPerformance.getId()) == null) {
                    throw new NonexistentEntityException("L'indicateurPerformance " + indicateurPerformance.getNom()+ " n'existe plus.");
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
            IndicateurPerformance indicateurPerformance;
            try {
                indicateurPerformance = em.getReference(IndicateurPerformance.class, id);
                indicateurPerformance.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The indicateurPerformance with id " + id + " no longer exists.", enfe);
            }
            em.remove(indicateurPerformance);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<IndicateurPerformance> findAllIndicateurPerformances() {
        try {
            String qlString = "SELECT indicateurPerformance from IndicateurPerformance indicateurPerformance";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public IndicateurPerformance findIndicateurPerformance(Long id) {
        try {
            return em.find(IndicateurPerformance.class, id);
        } finally {
            em.close();
        }
    }
}
