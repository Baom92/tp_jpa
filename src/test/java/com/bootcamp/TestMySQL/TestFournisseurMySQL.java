/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.TestMySQL;

import com.bootcamp.Controlleur.BaseControlleur;
import com.bootcamp.Controlleur.FournisseurControlleur;
import com.bootcamp.Entites.Fournisseur;
import com.bootcamp.Entites.Programme_has_Fournisseur;
import com.bootcamp.Entites.Projet_has_Fournisseur;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class TestFournisseurMySQL {
    
    public TestFournisseurMySQL() {
    }

    /**
     * Test of getAllFournisseurByProgramme method, of class FournisseurControlleur.
     */
    @Test
    public void testGetAllFournisseurByProgramme() {
        System.out.println("getAllFournisseurByProgramme");
        
        BaseControlleur<Programme_has_Fournisseur> instancebp = new BaseControlleur<>("TP_JPA_PU", Programme_has_Fournisseur.class);
        BaseControlleur<Fournisseur> instanceb = new BaseControlleur<>("TP_JPA_PU", Fournisseur.class);
        BaseControlleur<Programme> instancep = new BaseControlleur<>("TP_JPA_PU", Programme.class);
        
        List expResult = null;
        Fournisseur f1 = new Fournisseur(1,"Marley");
        Fournisseur f3 = new Fournisseur(2,"Dupont");
        Fournisseur f4 = new Fournisseur(3,"Ducobu");
        Fournisseur f2 = new Fournisseur(4,"Mistyc");
        
        Programme p1 = new Programme(1,"Routes", "Construction de routes");
        Programme p2 = new Programme(2,"Ecoles", "Construction de salles de classes");
        
        Programme_has_Fournisseur bp1 = new Programme_has_Fournisseur(p1.getId(), f1.getId(), p1, f1);
        bp1.setFonds("1.000.000.000");
        Programme_has_Fournisseur bp2 = new Programme_has_Fournisseur(p1.getId(), f2.getId(), p1, f2);
        bp2.setFonds("1.000.000.000");
        Programme_has_Fournisseur bp3 = new Programme_has_Fournisseur(p2.getId(), f1.getId(), p2, f1);
        bp3.setFonds("1.000.000.000");
        Programme_has_Fournisseur bp4 = new Programme_has_Fournisseur(p1.getId(), f3.getId(), p1, f3);
        bp4.setFonds("1.000.000.000");
        Programme_has_Fournisseur bp5 = new Programme_has_Fournisseur(p1.getId(), f4.getId(), p1, f4);
        bp5.setFonds("1.000.000.000");
        Programme_has_Fournisseur bp6 = new Programme_has_Fournisseur(p2.getId(), f4.getId(), p2, f4);
        bp6.setFonds("1.000.000.000");
        Programme_has_Fournisseur bp7 = new Programme_has_Fournisseur(p2.getId(), f2.getId(), p2, f2);
        bp7.setFonds("1.000.000.000");
        
        instancebp.create(bp1); instancebp.create(bp2); instancebp.create(bp3); instancebp.create(bp4); instancebp.create(bp4); instancebp.create(bp5); instancebp.create(bp6); instancebp.create(bp7);
        
        List result = new FournisseurControlleur().getAllFournisseurByProgramme(p1, "TP_JPA_PU");
        if (result!=expResult) {
            System.out.println("Test getAllFournisseurByProgramme a réussi");
        }
    }

    /**
     * Test of findAllFournisseurByProjet method, of class FournisseurControlleur.
     */
    @Test
    public void testGetAllFournisseurByProjet() {
        System.out.println("getAllFournisseurByProjet");
        
        BaseControlleur<Projet_has_Fournisseur> instancebp = new BaseControlleur<>("TP_JPA_PU", Projet_has_Fournisseur.class);
        BaseControlleur<Fournisseur> instanceb = new BaseControlleur<>("TP_JPA_PU", Fournisseur.class);
        BaseControlleur<Projet> instancep = new BaseControlleur<>("TP_JPA_PU", Projet.class);
        
        List expResult = null;
        Fournisseur f1 = new Fournisseur(1,"Marley");
        Fournisseur f3 = new Fournisseur(2,"Dupont");
        Fournisseur f4 = new Fournisseur(3,"Ducobu");
        Fournisseur f2 = new Fournisseur(4,"Mistyc");
        
        Projet p1 = new Projet(1,"Routes", "Construction de routes");
        Projet p2 = new Projet(2,"Ecoles", "Construction de salles de classes");
        
        Projet_has_Fournisseur bp1 = new Projet_has_Fournisseur(p1.getId(), f1.getId(), p1, f1);
        bp1.setFonds("1.000.000.000");
        Projet_has_Fournisseur bp2 = new Projet_has_Fournisseur(p1.getId(), f2.getId(), p1, f2);
        bp2.setFonds("1.000.000.000");
        Projet_has_Fournisseur bp3 = new Projet_has_Fournisseur(p2.getId(), f1.getId(), p2, f1);
        bp3.setFonds("1.000.000.000");
        Projet_has_Fournisseur bp4 = new Projet_has_Fournisseur(p1.getId(), f3.getId(), p1, f3);
        bp4.setFonds("1.000.000.000");
        Projet_has_Fournisseur bp5 = new Projet_has_Fournisseur(p1.getId(), f4.getId(), p1, f4);
        bp5.setFonds("1.000.000.000");
        Projet_has_Fournisseur bp6 = new Projet_has_Fournisseur(p2.getId(), f4.getId(), p2, f4);
        bp6.setFonds("1.000.000.000");
        Projet_has_Fournisseur bp7 = new Projet_has_Fournisseur(p2.getId(), f2.getId(), p2, f2);
        bp7.setFonds("1.000.000.000");
        
        instancebp.create(bp1); instancebp.create(bp2); instancebp.create(bp3); instancebp.create(bp4); instancebp.create(bp4); instancebp.create(bp5); instancebp.create(bp6); instancebp.create(bp7);
        
        List result = new FournisseurControlleur().getAllFournisseurByProjet(p1, "TP_JPA_PU");
        if (result!=expResult) {
            System.out.println("Test getAllFournisseurByProjet a réussi");
        }
    }
    
}
