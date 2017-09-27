/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Test;

import com.bootcamp.Entites.Beneficiaire;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bello
 */
public class Main {

    public static void main(String[] args) {
        //--- Création d'un EntityManageter
        System.out.println("Création d'un EntityManager");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP_JPA_PU");
        
        //--- Création d'un nouveau client
        System.out.println("Création d'un client");
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setNom("Dupont");

        //--- persistons ce client dans la base
        System.out.println("Ajout du Beneficiare dans la base en cours...");
        emf.createEntityManager().persist(beneficiaire);
        System.out.println("Transaction validée");
    }
}
