/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Controlleur.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bello
 */
public class BaseControlleur<T> {

    private EntityManager em;
    private Class entityClass;

    public BaseControlleur(String pu, Class entityClass) {
        this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
        this.entityClass = entityClass;
    }

    // Créer un nouveau entite
    public boolean create(T entite) {
        this.em.getTransaction().begin();
        this.em.persist(entite);
        this.em.getTransaction().commit();
        return true;
    }

    // Modifier un entite
    public boolean edit(T entite) throws NonexistentEntityException, Exception {
        this.em.getTransaction().begin();
        this.em.merge(entite);
        this.em.getTransaction().commit();
        return true;
    }

    // Suprimmer un entite
    public boolean destroy(T entite) throws NonexistentEntityException {
        this.em.getTransaction().begin();
        this.em.remove(entite);
        this.em.getTransaction().commit();
        return true;
    }

    // Recupérer la liste de tous les entites
    public List<T> getAllEntities() {
        String qlString = "SELECT b FROM " + this.entityClass.getSimpleName() + " b";
        Query q = this.em.createQuery(qlString);
        List<T> listeEntities = q.getResultList();
        return listeEntities;
    }

    // Recupérer une entité grâce à son id
    public T getEntitiesById(int id) {
        return (T) this.em.find(this.entityClass, id);
    }

    // Recupérer la liste de tous les entites en fonction d'une propriété donnée
    public List<T> getAllEntitiesByProperties(Object properties, String namePro) {
        String q = "SELECT DISTINCT g FROM " + this.entityClass.getSimpleName() + " g WHERE g." + namePro + "=:properties";
        Query query = this.em.createQuery(q);
        query.setParameter("properties", properties);

        List<T> listeEntities = query.getResultList();
        return listeEntities;
    }
}
