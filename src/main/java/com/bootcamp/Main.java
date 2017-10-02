/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.Controlleur.BaseControlleur;
import com.bootcamp.Entites.Beneficiaire;

/**
 *
 * @author Bello
 */
public class Main {

    public static void main(String[] args) {
        //--- Création d'un nouveau client
        System.out.println("Création d'un client");
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setNom("Dupont");

        //--- persistons ce client dans la base
        System.out.println("Ajout du Beneficiare dans la base en cours...");
        BaseControlleur<Beneficiaire> controlleur = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        controlleur.create(beneficiaire);
        System.out.println("Transaction validée");
        
        //--- Récupération de ce client dans la base
        System.out.println("Lecture du Beneficiare dans la base en cours...");
        Beneficiaire ben = controlleur.getAllEntities().get(0);
        System.out.println(ben.getNom());
    }
}
