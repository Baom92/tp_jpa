/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import com.bootcamp.Enum.TypeBailleur;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    @Column(name = "typeDeBailleur")
    private TypeBailleur typeDeBailleur;

//    @ManyToMany(mappedBy = "bailleurs")
//    private List<Projet> projets;
    
    @OneToMany(mappedBy = "bailleur" , cascade = CascadeType.ALL)
    private List<Bailleur_has_Projet> projets;

//    @ManyToMany(mappedBy = "bailleurs")
//    private List<Programme> programme;
    
    @OneToMany(mappedBy = "bailleur" , cascade = CascadeType.ALL)
    private List<Bailleur_has_Programme> programmes;

    public Bailleur() {
        super();
    }
    
    public Bailleur(int id, String nom, TypeBailleur type) {
        super(id, nom);
        this.typeDeBailleur = type;
    }
    
    public Bailleur(String nom, TypeBailleur type) {
        super(nom);
        this.typeDeBailleur = type;
    }
    
    public TypeBailleur getTypeBailleur() {
        return this.typeDeBailleur;
    }

    public void setTypeBailleur(TypeBailleur type) {
        this.typeDeBailleur = type;
    }

    @XmlTransient
    public List<Bailleur_has_Projet> getProjetList() {
        return this.projets;
    }

    public void setProjetList(List<Bailleur_has_Projet> projets) {
        this.projets = projets;
    }

    @XmlTransient
    public List<Bailleur_has_Programme> getProgrammeList() {
        return this.programmes;
    }

    public void setProgrammeList(List<Bailleur_has_Programme> programme) {
        this.programmes = programme;
    }
}
