/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.TestMySQL;

import com.bootcamp.Controlleur.BaseControlleur;
import com.bootcamp.Controlleur.BeneficiaireControlleur;
import com.bootcamp.Entites.Beneficiaire;
import com.bootcamp.Entites.Programme_has_Beneficiaire;
import com.bootcamp.Entites.Beneficiaire_has_Projet;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class TestBeneficiaireMySQL {
    
    public TestBeneficiaireMySQL() {
    }

    /**
     * Test of getAllBeneficiaireByProgramme method, of class BeneficiaireControlleur.
     */
    @Test
    public void testGetAllBeneficiaireByProgramme() {
        System.out.println("getAllBeneficiaireByProgramme");
        
        BaseControlleur<Programme_has_Beneficiaire> instancebp = new BaseControlleur<>("TP_JPA_PU", Programme_has_Beneficiaire.class);
        BaseControlleur<Beneficiaire> instanceb = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        BaseControlleur<Programme> instancep = new BaseControlleur<>("TP_JPA_PU", Programme.class);
        
        List expResult = null;
        Beneficiaire b1 = new Beneficiaire(1,"Marley");
        Beneficiaire b3 = new Beneficiaire(2,"Dupont");
        Beneficiaire b4 = new Beneficiaire(3,"Ducobu");
        Beneficiaire b2 = new Beneficiaire(4,"Mistyc");
        
        Programme p1 = new Programme(1,"Routes", "Construction de routes");
        Programme p2 = new Programme(2,"Ecoles", "Construction de salles de classes");
        
        Programme_has_Beneficiaire bp1 = new Programme_has_Beneficiaire(p1.getId(), b1.getId(), p1, b1);
        bp1.setFonds("1.000.000.000");
        Programme_has_Beneficiaire bp2 = new Programme_has_Beneficiaire(p1.getId(), b2.getId(), p1, b2);
        bp2.setFonds("1.000.000.000");
        Programme_has_Beneficiaire bp3 = new Programme_has_Beneficiaire(p2.getId(), b1.getId(), p2, b1);
        bp3.setFonds("1.000.000.000");
        Programme_has_Beneficiaire bp4 = new Programme_has_Beneficiaire(p1.getId(), b3.getId(), p1, b3);
        bp4.setFonds("1.000.000.000");
        Programme_has_Beneficiaire bp5 = new Programme_has_Beneficiaire(p1.getId(), b4.getId(), p1, b4);
        bp5.setFonds("1.000.000.000");
        Programme_has_Beneficiaire bp6 = new Programme_has_Beneficiaire(p2.getId(), b4.getId(), p2, b4);
        bp6.setFonds("1.000.000.000");
        Programme_has_Beneficiaire bp7 = new Programme_has_Beneficiaire(p2.getId(), b2.getId(), p2, b2);
        bp7.setFonds("1.000.000.000");
        
        instancebp.create(bp1); instancebp.create(bp2); instancebp.create(bp3); instancebp.create(bp4); instancebp.create(bp4); instancebp.create(bp5); instancebp.create(bp6); instancebp.create(bp7);
        
        List result = new BeneficiaireControlleur().getAllBeneficiaireByProgramme(p1, "TP_JPA_PU");
        if (result!=expResult) {
            System.out.println("Test getAllBeneficiaireByProgramme a réussi");
        }
    }

    /**
     * Test of findAllBeneficiaireByProjet method, of class BeneficiaireControlleur.
     */
    @Test
    public void testGetAllBeneficiaireByProjet() {
        System.out.println("getAllBeneficiaireByProjet");
        
        BaseControlleur<Beneficiaire_has_Projet> instancebp = new BaseControlleur<>("TP_JPA_PU", Beneficiaire_has_Projet.class);
        BaseControlleur<Beneficiaire> instanceb = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
        BaseControlleur<Projet> instancep = new BaseControlleur<>("TP_JPA_PU", Projet.class);
        
        List expResult = null;
        Beneficiaire b1 = new Beneficiaire(1,"Marley");
        Beneficiaire b3 = new Beneficiaire(2,"Dupont");
        Beneficiaire b4 = new Beneficiaire(3,"Ducobu");
        Beneficiaire b2 = new Beneficiaire(4,"Mistyc");
        
        Projet p1 = new Projet(1,"Routes", "Construction de routes");
        Projet p2 = new Projet(2,"Ecoles", "Construction de salles de classes");
        
        Beneficiaire_has_Projet bp1 = new Beneficiaire_has_Projet(b1.getId(), p1.getId(), b1, p1);
        bp1.setFonds("1.000.000.000");
        Beneficiaire_has_Projet bp2 = new Beneficiaire_has_Projet(b2.getId(), p1.getId(), b2, p1);
        bp2.setFonds("1.000.000.000");
        Beneficiaire_has_Projet bp3 = new Beneficiaire_has_Projet(b1.getId(), p2.getId(), b1, p2);
        bp3.setFonds("1.000.000.000");
        Beneficiaire_has_Projet bp4 = new Beneficiaire_has_Projet(b3.getId(), p1.getId(), b3, p1);
        bp4.setFonds("1.000.000.000");
        Beneficiaire_has_Projet bp5 = new Beneficiaire_has_Projet(b4.getId(), p1.getId(), b4, p1);
        bp5.setFonds("1.000.000.000");
        Beneficiaire_has_Projet bp6 = new Beneficiaire_has_Projet(b4.getId(), p2.getId(), b4, p2);
        bp6.setFonds("1.000.000.000");
        Beneficiaire_has_Projet bp7 = new Beneficiaire_has_Projet(b2.getId(), p2.getId(), b2, p2);
        bp7.setFonds("1.000.000.000");
        
        instancebp.create(bp1); instancebp.create(bp2); instancebp.create(bp3); instancebp.create(bp4); instancebp.create(bp4); instancebp.create(bp5); instancebp.create(bp6); instancebp.create(bp7);
        
        List result = new BeneficiaireControlleur().getAllBeneficiaireByProjet(p1, "TP_JPA_PU");
        if (result!=expResult) {
            System.out.println("Test getAllBeneficiaireByProjet a réussi");
        }
    }
    
}
