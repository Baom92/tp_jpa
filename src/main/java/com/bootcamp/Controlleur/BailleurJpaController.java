/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import com.bootcamp.Entites.Bailleur;
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
public class BailleurJpaController implements Serializable {

    private EntityManager em;
    
    public BailleurJpaController(EntityManager em) {
        this.em = em;
    }
    
    // Créer un nouveau bailleur
    public void create(Bailleur bailleur) {
        try {
            em.getTransaction().begin();
            em.persist(bailleur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Modifier un bailleur
    public void edit(Bailleur bailleur) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            bailleur = em.merge(bailleur);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (findBailleur(bailleur.getId()) == null) {
                    throw new NonexistentEntityException("Le bailleur " + bailleur.getNom() + " n'existe plus.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Suprimmer un bailleur
    public void destroy(Long id) throws NonexistentEntityException {
        try {
            em.getTransaction().begin();
            Bailleur bailleur;
            try {
                bailleur = em.getReference(Bailleur.class, id);
                bailleur.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bailleur with id " + id + " no longer exists.", enfe);
            }
            em.remove(bailleur);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Recupérer la liste de tous les bailleurs
    private ArrayList<Bailleur> findAllBailleurs() {
        try {
            String qlString = "SELECT b from Bailleur b";
            Query q = em.createQuery(qlString);
            return (ArrayList)q.getResultList();
        } finally {
            em.close();
        }
    }

    // Recupérer un bailleur par son id
    public Bailleur findBailleur(Long id) {
        try {
            return em.find(Bailleur.class, id);
        } finally {
            em.close();
        }
    }
    
    //Recuperer tous les bailleurs d'un même programme
    public ArrayList<Bailleur> getAllBailleurByProgramme(Programme programme) {
        String q = "SELECT DISTINCT g FROM Bailleur u LEFT JOIN u.programme g WHERE u = :programme";
        TypedQuery<Bailleur> query = this.em.createQuery(q, Bailleur.class);
        query.setParameter("programme", programme);
        
        ArrayList<Bailleur> listeBailleurs = (ArrayList)query.getResultList();
        return listeBailleurs;
    }
    
    //Recuperer tous les bailleurs d'un même projet
    public ArrayList<Bailleur> findAllBailleurByProjet(Projet projet) {
        String q = "SELECT DISTINCT g FROM Bailleur u LEFT JOIN u.projet g WHERE u = :projet";
        TypedQuery<Bailleur> query = this.em.createQuery(q, Bailleur.class);
        query.setParameter("programme", projet);
        
        ArrayList<Bailleur> listeBailleurs = (ArrayList)query.getResultList();
        return listeBailleurs;
    }
}
