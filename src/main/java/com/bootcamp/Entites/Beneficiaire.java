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
import javax.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "beneficiaires")
    private ArrayList<Programme> programme;
    
    @ManyToMany(mappedBy = "beneficiaires")
    private ArrayList<Projet> projet;
    
    public Beneficiaire() {
        super();
    }
    
    public Beneficiaire(long id, String nom) {
        super(id, nom);
    }
    
    public Beneficiaire(String nom) {
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
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiaire)) {
            return false;
        }
        Beneficiaire other = (Beneficiaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.Entites.Beneficiaire[ id=" + id + " ]";
    }
}
