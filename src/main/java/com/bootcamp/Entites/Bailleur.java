/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import com.bootcamp.Enum.TypeBailleur;
import java.util.ArrayList;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "tp_bailleur")
@Access(AccessType.FIELD)
@DiscriminatorValue("BAILLEUR")

public class Bailleur extends Personne {

    @Lob
    @Enumerated(EnumType.STRING)
    @Column(name = "typeDeBailleur", nullable=false)
    private TypeBailleur typeDeBailleur;

    @ManyToMany(mappedBy = "bailleurs")
    private ArrayList<Projet> projet;

    @ManyToMany(mappedBy = "bailleurs")
    private ArrayList<Programme> programme;

    public Bailleur() {
        super();
    }
    
    public Bailleur(long id, String nom, TypeBailleur type) {
        super(id, nom);
        this.typeDeBailleur = type;
    }
    
    public Bailleur(String nom, TypeBailleur type) {
        super(nom);
        this.typeDeBailleur = type;
    }
    
    public TypeBailleur getTypeBailleur() {
        return typeDeBailleur;
    }

    public void setTypeBailleur(TypeBailleur type) {
        this.typeDeBailleur = type;
    }

    @XmlTransient
    public ArrayList<Projet> getProjetList() {
        return projet;
    }

    public void setProjetList(ArrayList<Projet> projet) {
        this.projet = projet;
    }

    @XmlTransient
    public ArrayList<Programme> getProgrammeList() {
        return programme;
    }

    public void setProgrammeList(ArrayList<Programme> programme) {
        this.programme = programme;
    }
}
