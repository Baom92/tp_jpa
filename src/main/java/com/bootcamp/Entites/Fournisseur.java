/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import java.util.ArrayList;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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

    @OneToMany(mappedBy = "fournisseur")
    private ArrayList<Programme> programme;
    
    @OneToMany(mappedBy = "fournisseur")
    private ArrayList<Projet> projet;
    
    public Fournisseur() {
        super();
    }
    
    public Fournisseur(long id, String nom) {
        super(id, nom);
    }
    
    public Fournisseur(String nom) {
        super(nom);
    }
    
    @XmlTransient
    public ArrayList<Programme> getProgrammeList() {
        return programme;
    }

    public void setProgrammeList(ArrayList<Programme> programme) {
        this.programme = programme;
    }
    
    @XmlTransient
    public ArrayList<Projet> getProjetList() {
        return projet;
    }

    public void setProjetList(ArrayList<Projet> projet) {
        this.projet = projet;
    }
}
