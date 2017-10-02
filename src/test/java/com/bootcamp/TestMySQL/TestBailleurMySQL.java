/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.TestMySQL;

import com.bootcamp.Controlleur.BailleurControlleur;
import com.bootcamp.Controlleur.BaseControlleur;
import com.bootcamp.Entites.Bailleur;
import com.bootcamp.Entites.Bailleur_has_Programme;
import com.bootcamp.Entites.Bailleur_has_Projet;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import com.bootcamp.Enum.TypeBailleur;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class TestBailleurMySQL {
    
    public TestBailleurMySQL() {
    }

    /**
     * Test of getAllBailleurByProgramme method, of class BailleurControlleur.
     */
    @Test
    public void testGetAllBailleurByProgramme() {
        System.out.println("getAllBailleurByProgramme");
        
        BaseControlleur<Bailleur_has_Programme> instancebp = new BaseControlleur<>("TP_JPA_PU", Bailleur_has_Programme.class);
        BaseControlleur<Bailleur> instanceb = new BaseControlleur<>("TP_JPA_PU", Bailleur.class);
        BaseControlleur<Programme> instancep = new BaseControlleur<>("TP_JPA_PU", Programme.class);
        
        List expResult = null;
        Bailleur b1 = new Bailleur(1,"Marley", TypeBailleur.PRIVE);
        Bailleur b3 = new Bailleur(2,"Dupont", TypeBailleur.PARTENAIRE_INTERNATIONNAL);
        Bailleur b4 = new Bailleur(3,"Ducobu", TypeBailleur.GOUVERNEMENTALE);
        Bailleur b2 = new Bailleur(4,"Mistyc", TypeBailleur.NON_GOUVERNEMENTALE);
        
        Programme p1 = new Programme(1,"Routes", "Construction de routes");
        Programme p2 = new Programme(2,"Ecoles", "Construction de salles de classes");
        
        Bailleur_has_Programme bp1 = new Bailleur_has_Programme(b1.getId(), p1.getId(), b1, p1);
        bp1.setFonds("1.000.000.000");
        Bailleur_has_Programme bp2 = new Bailleur_has_Programme(b2.getId(), p1.getId(), b2, p1);
        bp2.setFonds("1.000.000.000");
        Bailleur_has_Programme bp3 = new Bailleur_has_Programme(b1.getId(), p2.getId(), b1, p2);
        bp3.setFonds("1.000.000.000");
        Bailleur_has_Programme bp4 = new Bailleur_has_Programme(b3.getId(), p1.getId(), b3, p1);
        bp4.setFonds("1.000.000.000");
        Bailleur_has_Programme bp5 = new Bailleur_has_Programme(b4.getId(), p1.getId(), b4, p1);
        bp5.setFonds("1.000.000.000");
        Bailleur_has_Programme bp6 = new Bailleur_has_Programme(b4.getId(), p2.getId(), b4, p2);
        bp6.setFonds("1.000.000.000");
        Bailleur_has_Programme bp7 = new Bailleur_has_Programme(b2.getId(), p2.getId(), b2, p2);
        bp7.setFonds("1.000.000.000");
        
        instancebp.create(bp1); instancebp.create(bp2); instancebp.create(bp3); instancebp.create(bp4); instancebp.create(bp4); instancebp.create(bp5); instancebp.create(bp6); instancebp.create(bp7);
        
        List result = new BailleurControlleur().getAllBailleurByProgramme(p1, "TP_JPA_PU");
        if (result!=expResult) {
            System.out.println("Test getAllBailleurByProgramme a réussi");
        }
    }

    /**
     * Test of findAllBailleurByProjet method, of class BailleurControlleur.
     */
    @Test
    public void testGetAllBailleurByProjet() {
        System.out.println("getAllBailleurByProjet");
        
        BaseControlleur<Bailleur_has_Projet> instancebp = new BaseControlleur<>("TP_JPA_PU", Bailleur_has_Projet.class);
        BaseControlleur<Bailleur> instanceb = new BaseControlleur<>("TP_JPA_PU", Bailleur.class);
        BaseControlleur<Projet> instancep = new BaseControlleur<>("TP_JPA_PU", Projet.class);
        
        List expResult = null;
        Bailleur b1 = new Bailleur(1,"Marley", TypeBailleur.PRIVE);
        Bailleur b3 = new Bailleur(2,"Dupont", TypeBailleur.PARTENAIRE_INTERNATIONNAL);
        Bailleur b4 = new Bailleur(3,"Ducobu", TypeBailleur.GOUVERNEMENTALE);
        Bailleur b2 = new Bailleur(4,"Mistyc", TypeBailleur.NON_GOUVERNEMENTALE);
        
        Projet p1 = new Projet(1,"Routes", "Construction de routes");
        Projet p2 = new Projet(2,"Ecoles", "Construction de salles de classes");
        
        Bailleur_has_Projet bp1 = new Bailleur_has_Projet(b1.getId(), p1.getId(), b1, p1);
        bp1.setFonds("1.000.000.000");
        Bailleur_has_Projet bp2 = new Bailleur_has_Projet(b2.getId(), p1.getId(), b2, p1);
        bp2.setFonds("1.000.000.000");
        Bailleur_has_Projet bp3 = new Bailleur_has_Projet(b1.getId(), p2.getId(), b1, p2);
        bp3.setFonds("1.000.000.000");
        Bailleur_has_Projet bp4 = new Bailleur_has_Projet(b3.getId(), p1.getId(), b3, p1);
        bp4.setFonds("1.000.000.000");
        Bailleur_has_Projet bp5 = new Bailleur_has_Projet(b4.getId(), p1.getId(), b4, p1);
        bp5.setFonds("1.000.000.000");
        Bailleur_has_Projet bp6 = new Bailleur_has_Projet(b4.getId(), p2.getId(), b4, p2);
        bp6.setFonds("1.000.000.000");
        Bailleur_has_Projet bp7 = new Bailleur_has_Projet(b2.getId(), p2.getId(), b2, p2);
        bp7.setFonds("1.000.000.000");
        
        instancebp.create(bp1); instancebp.create(bp2); instancebp.create(bp3); instancebp.create(bp4); instancebp.create(bp4); instancebp.create(bp5); instancebp.create(bp6); instancebp.create(bp7);
        
        List result = new BailleurControlleur().getAllBailleurByProjet(p1, "TP_JPA_PU");
        if (result!=expResult) {
            System.out.println("Test getAllBailleurByProjet a réussi");
        }
    }
    
}
