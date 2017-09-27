/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.Fournisseur;
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
public class FournisseurJpaController implements Serializable {

    private EntityManager em = null;

    public FournisseurJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouveau fournisseur
    public void create(Fournisseur fournisseur) {
        try {
            em.getTransaction().begin();
            em.persist(fournisseur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un fournisseur
    public void edit(Fournisseur fournisseur) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            fournisseur = em.merge(fournisseur);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findFournisseur(fournisseur.getId()) == null) {
                    throw new NonexistentEntityException("Le fournisseur " + fournisseur.getNom()+ " n'existe plus.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Suprimmer un fournisseur
    public void destroy(Long id) throws NonexistentEntityException {
        try {
            em.getTransaction().begin();
            Fournisseur fournisseur;
            try {
                fournisseur = em.getReference(Fournisseur.class, id);
                fournisseur.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fournisseur with id " + id + " no longer exists.", enfe);
            }
            em.remove(fournisseur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private ArrayList<Fournisseur> findAllFournisseurs() {
        try {
            String qlString = "SELECT fournisseur from Fournisseur fournisseur";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    public Fournisseur findFournisseur(Long id) {
        try {
            return em.find(Fournisseur.class, id);
        } finally {
            em.close();
        }
    }
    
    //Recuperer tous les fournisseurs d'un même programme
    public ArrayList<Fournisseur> getAllFournisseurByProgramme(Programme programme) {
        String q = "SELECT DISTINCT g FROM Fournisseur u LEFT JOIN u.programme g WHERE u = :programme";
        TypedQuery<Fournisseur> query = this.em.createQuery(q, Fournisseur.class);
        query.setParameter("programme", programme);
        
        ArrayList<Fournisseur> listeFournisseurs = (ArrayList)query.getResultList();
        return listeFournisseurs;
    }
    
    //Recuperer tous les fournisseurs d'un même projet
    public ArrayList<Fournisseur> findAllFournisseurByProjet(Projet projet) {
        String q = "SELECT DISTINCT g FROM Fournisseur u LEFT JOIN u.projet g WHERE u = :projet";
        TypedQuery<Fournisseur> query = this.em.createQuery(q, Fournisseur.class);
        query.setParameter("programme", projet);
        
        ArrayList<Fournisseur> listeFournisseurs = (ArrayList)query.getResultList();
        return listeFournisseurs;
    }
}
