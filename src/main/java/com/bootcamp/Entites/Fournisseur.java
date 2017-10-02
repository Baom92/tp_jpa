/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bello
 */
@Entity

@Table(name = "tp_fournisseur")
@Access(AccessType.FIELD)
@DiscriminatorValue("FOURNISSEUR")

public class Fournisseur extends Personne {

//    @ManyToMany(mappedBy = "fournisseurs")
//    private List<Programme> programmes;
    
    @OneToMany(mappedBy = "fournisseur" , cascade = CascadeType.ALL)
    private List<Programme_has_Fournisseur> programmes;
    
//    @ManyToMany(mappedBy = "fournisseurs")
//    private List<Projet> projet;
    
    @OneToMany(mappedBy = "fournisseur" , cascade = CascadeType.ALL)
    private List<Projet_has_Fournisseur> projets;
    
    public Fournisseur() {
        super();
    }
    
    public Fournisseur(int id, String nom) {
        super(id, nom);
    }
    
    public Fournisseur(String nom) {
        super(nom);
    }
    
    @XmlTransient
    public List<Programme_has_Fournisseur> getProgrammeList() {
        return programmes;
    }

    public void setProgrammeList(List<Programme_has_Fournisseur> programmes) {
        this.programmes = programmes;
    }
    
    @XmlTransient
    public List<Projet_has_Fournisseur> getProjetList() {
        return projets;
    }

    public void setProjetList(List<Projet_has_Fournisseur> projet) {
        this.projets = projet;
    }
}
