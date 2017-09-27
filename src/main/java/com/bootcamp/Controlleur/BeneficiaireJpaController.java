/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.Beneficiaire;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bello
 */
public class BeneficiaireJpaController implements Serializable {

    private EntityManager em = null;

    public BeneficiaireJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouveau Beneficiaire
    public void create(Beneficiaire beneficiaire) {
        try {
            em.getTransaction().begin();
            em.persist(beneficiaire);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un beneficiaire
    public void edit(Beneficiaire beneficiaire) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            beneficiaire = em.merge(beneficiaire);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findBeneficiaire(beneficiaire.getId()) == null) {
                    throw new NonexistentEntityException("Le beneficiaire " + beneficiaire.getNom()+ " n'existe plus.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Suprimmer un beneficiaire
    public void destroy(Long id) throws NonexistentEntityException {
        try {
            em.getTransaction().begin();
            Beneficiaire beneficiaire;
            try {
                beneficiaire = em.getReference(Beneficiaire.class, id);
                beneficiaire.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The beneficiaire with id " + id + " no longer exists.", enfe);
            }
            em.remove(beneficiaire);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<Beneficiaire> findAllBeneficiaires() {
        try {
            String qlString = "SELECT b from Beneficiaire b";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public Beneficiaire findBeneficiaire(Long id) {
        try {
            return em.find(Beneficiaire.class, id);
        } finally {
            em.close();
        }
    }
    
    //Recuperer tous les beneficiaires d'un même programme
    public ArrayList<Beneficiaire> getAllBeneficiaireByProgramme(Programme programme) {
        String q = "SELECT DISTINCT g FROM Beneficiaire u LEFT JOIN u.programme g WHERE u = :programme";
        TypedQuery<Beneficiaire> query = this.em.createQuery(q, Beneficiaire.class);
        query.setParameter("programme", programme);
        
        ArrayList<Beneficiaire> listeBeneficiaires = (ArrayList)query.getResultList();
        return listeBeneficiaires;
    }
    
    //Recuperer tous les beneficiaires d'un même projet
    public ArrayList<Beneficiaire> findAllBeneficiaireByProjet(Projet projet) {
        String q = "SELECT DISTINCT g FROM Beneficiaire u LEFT JOIN u.projet g WHERE u = :projet";
        TypedQuery<Beneficiaire> query = this.em.createQuery(q, Beneficiaire.class);
        query.setParameter("programme", projet);
        
        ArrayList<Beneficiaire> listeBeneficiaires = (ArrayList)query.getResultList();
        return listeBeneficiaires;
    }
}
