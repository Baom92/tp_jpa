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
@Table(name = "tp_beneficiaire")
@Access(AccessType.FIELD)
@DiscriminatorValue("BENEFICIAIRE")

public class Beneficiaire extends Personne {

//    @ManyToMany(mappedBy = "beneficiaires")
//    private List<Programme> programmes;
    
    @OneToMany(mappedBy = "beneficiaire" , cascade = CascadeType.ALL)
    private List<Programme_has_Beneficiaire> programmes;
    
//    @ManyToMany(mappedBy = "beneficiaires")
//    private List<Projet> projet;
    
    @OneToMany(mappedBy = "beneficiaire" , cascade = CascadeType.ALL)
    private List<Beneficiaire_has_Projet> projets;
    
    public Beneficiaire() {
        super();
    }
    
    public Beneficiaire(int id, String nom) {
        super(id, nom);
    }
    
    public Beneficiaire(String nom) {
        super(nom);
    }
    
    @XmlTransient
    public List<Programme_has_Beneficiaire> getProgrammeList() {
        return programmes;
    }

    public void setProgrammeList(List<Programme_has_Beneficiaire> programmes) {
        this.programmes = programmes;
    }
    
    @XmlTransient
    public List<Beneficiaire_has_Projet> getProjetList() {
        return projets;
    }

    public void setProjetList(List<Beneficiaire_has_Projet> projet) {
        this.projets = projet;
    }
}
