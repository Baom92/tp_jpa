/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "tp_bailleur_has_projet")
@Access(AccessType.FIELD)
//@IdClass(Bailleur_has_Projet.class)

public class Bailleur_has_Projet implements Serializable {

    @Id
    @Column(name = "bailleur_id", nullable=false)
    private int bailleur_id;

    @Id
    @Column(name = "projet_id", nullable=false)
    private int projet_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "bailleur_id", referencedColumnName = "ID")
    private Bailleur bailleur;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "projet_id", referencedColumnName = "ID")
    private Projet projet;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;
    
    public Bailleur_has_Projet() {
    }
    
    public Bailleur_has_Projet(int bailleur_id, int projet_id, Bailleur bailleur, Projet projet) {
        this.bailleur_id = bailleur_id;
        this.projet_id = projet_id;
        this.bailleur = bailleur;
        this.projet = projet;
    }
    
    public Bailleur_has_Projet(Bailleur bailleur, Projet projet) {
        this.bailleur = bailleur;
        this.projet = projet;
    }

    public Bailleur getBailleur() {
        return this.bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getFonds() {
        return this.fonds;
    }

    public void setFonds(String fonds) {
        this.fonds = fonds;
    }
}
