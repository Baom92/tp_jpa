/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Controlleur;

import com.bootcamp.Entites.Bailleur;
import com.bootcamp.Entites.Bailleur_has_Programme;
import com.bootcamp.Entites.Bailleur_has_Projet;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bello
 */
public class BailleurControlleur implements Serializable {

    //Recuperer tous les bailleurs d'un même programme
    public List<Bailleur> getAllBailleurByProgramme(Programme programme, String pu) {
        BaseControlleur<Bailleur_has_Programme> instance = new BaseControlleur<>(pu, Bailleur_has_Programme.class);
        List<Bailleur_has_Programme> result = instance.getAllEntitiesByProperties(programme.getId(), "programme_id");
        List<Bailleur> listeBailleurs = new LinkedList<>() ;
        for (int i=0; i<result.size();i++)
        {
            Bailleur entite = result.get(i).getBailleur();
            listeBailleurs.add(entite);
        }
        return listeBailleurs;
    }
    
    //Recuperer tous les bailleurs d'un même projet
    public List<Bailleur> getAllBailleurByProjet(Projet projet, String pu) {
        BaseControlleur<Bailleur_has_Projet> instance = new BaseControlleur<>(pu, Bailleur_has_Projet.class);
        List<Bailleur_has_Projet> result = instance.getAllEntitiesByProperties(projet.getId(), "projet_id");
        List<Bailleur> listeBailleurs = new LinkedList<>() ;
        for (int i=0; i<result.size();i++)
        {
            Bailleur entite = result.get(i).getBailleur();
            listeBailleurs.add(entite);
        }
        return listeBailleurs;
    }
}
