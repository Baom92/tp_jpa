/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Entites.Beneficiaire;
import com.bootcamp.Entites.Programme_has_Beneficiaire;
import com.bootcamp.Entites.Beneficiaire_has_Projet;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bello
 */
public class BeneficiaireControlleur implements Serializable {

    //Recuperer tous les bailleurs d'un même programme
    public List<Beneficiaire> getAllBeneficiaireByProgramme(Programme programme, String pu) {
        BaseControlleur<Programme_has_Beneficiaire> instance = new BaseControlleur<>(pu, Programme_has_Beneficiaire.class);
        List<Programme_has_Beneficiaire> result = instance.getAllEntitiesByProperties(programme.getId(), "programme_id");
        List<Beneficiaire> listeBeneficiaires = new LinkedList<>() ;
        for (int i=0; i<result.size();i++)
        {
            Beneficiaire entite = result.get(i).getBeneficiaire();
            listeBeneficiaires.add(entite);
        }
        return listeBeneficiaires;
    }
    
    //Recuperer tous les bailleurs d'un même projet
    public List<Beneficiaire> getAllBeneficiaireByProjet(Projet projet, String pu) {
        BaseControlleur<Beneficiaire_has_Projet> instance = new BaseControlleur<>(pu, Beneficiaire_has_Projet.class);
        List<Beneficiaire_has_Projet> result = instance.getAllEntitiesByProperties(projet.getId(), "projet_id");
        List<Beneficiaire> listeBeneficiaires = new LinkedList<>() ;
        for (int i=0; i<result.size();i++)
        {
            Beneficiaire entite = result.get(i).getBeneficiaire();
            listeBeneficiaires.add(entite);
        }
        return listeBeneficiaires;
    }
}
