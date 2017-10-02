/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.TestMySQL;

import com.bootcamp.Controlleur.BaseControlleur;
import com.bootcamp.Entites.Beneficiaire;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class TestGeneriqueMySQL {

    public TestGeneriqueMySQL() {
    }

    /**
     * Test de la methode create.
     */
    @Test
    public void testCreate() {
        BaseControlleur<Beneficiaire> instance = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        System.out.println("create Beneficiaire");
        Beneficiaire entite = new Beneficiaire();
        entite.setNom("Dupont");
        if (instance.create(entite)) {
            System.out.println("Test create a réussi");
        }
    }

    /**
     * Test de la methode edit.
     */
    @Test
    public void testEdit() throws Exception {
        BaseControlleur<Beneficiaire> instance = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        System.out.println("edit Beneficiaire");
        Beneficiaire entite = new Beneficiaire("Marley");
        instance.create(entite);
        Beneficiaire entite2 = instance.getAllEntities().get(0);
        entite2.setNom("Bello");
        if (instance.edit(entite2)) {
            System.out.println("Test edit a réussi");
        }
    }

    /**
     * Test de la methode destroy.
     */
    @Test
    public void testDestroy() throws Exception {
        BaseControlleur<Beneficiaire> instance = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        System.out.println("destroy Beneficiaire");
        Beneficiaire entite = new Beneficiaire("Marley");
        instance.create(entite);
        Beneficiaire entite2 = instance.getAllEntities().get(0);
        if (instance.destroy(entite2)) {
            System.out.println("Test destroy a réussi");
        }
    }

    /**
     * Test of getAllEntities method, of class BaseControlleur.
     */
    @Test
    public void testGetAllEntities() {
        BaseControlleur<Beneficiaire> instance = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        System.out.println("getAllEntities");
        List expResult = null;
        instance.create(new Beneficiaire("Marley"));
        instance.create(new Beneficiaire("Bob"));
        instance.create(new Beneficiaire("Dupont"));
        instance.create(new Beneficiaire("Ducobu"));
        instance.create(new Beneficiaire("Mistyc"));
        List result = instance.getAllEntities();
        if (result!=expResult) {
            System.out.println("Test getAllEntities a réussi");
        }
    }

    /**
     * Test of getEntitiesById method, of class BaseControlleur.
     */
    @Test
    public void testGetEntitiesById() {
        BaseControlleur<Beneficiaire> instance = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        System.out.println("getEntitiesById");
        Beneficiaire expResult = null;
        instance.create(new Beneficiaire("Marley"));
        instance.create(new Beneficiaire("Bob"));
        instance.create(new Beneficiaire("Dupont"));
        instance.create(new Beneficiaire("Ducobu"));
        instance.create(new Beneficiaire("Mistyc"));
        Beneficiaire result = instance.getEntitiesById(1);
        if (result!=expResult) {
            System.out.println("Test getEntitiesById a réussi");
        }
    }

    /**
     * Test of getAllEntitiesByProperties method, of class BaseControlleur.
     */
    @Test
    public void testGetAllEntitiesByProperties() {
        System.out.println("getAllEntitiesByProperties");
        BaseControlleur<Beneficiaire> instance = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        instance.create(new Beneficiaire("Marley"));
        instance.create(new Beneficiaire("Bob"));
        instance.create(new Beneficiaire("Dupont"));
        instance.create(new Beneficiaire("Ducobu"));
        instance.create(new Beneficiaire("Mistyc"));
        List expResult = null;
        List result = instance.getAllEntitiesByProperties("Dupont", "nom");
        if (result!=expResult) {
            System.out.println("Test getAllEntitiesByProperties a réussi");
        }
        
    }
}
