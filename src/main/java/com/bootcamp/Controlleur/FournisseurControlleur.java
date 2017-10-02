/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Entites.Fournisseur;
import com.bootcamp.Entites.Programme_has_Fournisseur;
import com.bootcamp.Entites.Projet_has_Fournisseur;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bello
 */
public class FournisseurControlleur implements Serializable {

    //Recuperer tous les bailleurs d'un même programme
    public List<Fournisseur> getAllFournisseurByProgramme(Programme programme, String pu) {
        BaseControlleur<Programme_has_Fournisseur> instance = new BaseControlleur<>(pu, Programme_has_Fournisseur.class);
        List<Programme_has_Fournisseur> result = instance.getAllEntitiesByProperties(programme.getId(), "programme_id");
        List<Fournisseur> listeFournisseurs = new LinkedList<>() ;
        for (int i=0; i<result.size();i++)
        {
            Fournisseur entite = result.get(i).getFournisseur();
            listeFournisseurs.add(entite);
        }
        return listeFournisseurs;
    }
    
    //Recuperer tous les bailleurs d'un même projet
    public List<Fournisseur> getAllFournisseurByProjet(Projet projet, String pu) {
        BaseControlleur<Projet_has_Fournisseur> instance = new BaseControlleur<>(pu, Projet_has_Fournisseur.class);
        List<Projet_has_Fournisseur> result = instance.getAllEntitiesByProperties(projet.getId(), "projet_id");
        List<Fournisseur> listeFournisseurs = new LinkedList<>() ;
        for (int i=0; i<result.size();i++)
        {
            Fournisseur entite = result.get(i).getFournisseur();
            listeFournisseurs.add(entite);
        }
        return listeFournisseurs;
    }
}
