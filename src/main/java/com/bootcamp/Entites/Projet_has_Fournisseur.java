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
@Table(name = "tp_projet_has_fournisseur")
@Access(AccessType.FIELD)
//@IdClass(Projet_has_Fournisseur.class)

public class Projet_has_Fournisseur implements Serializable {

    @Id
    @Column(name = "projet_id", nullable=false)
    private int projet_id;

    @Id
    @Column(name = "fournisseur_id", nullable=false)
    private int fournisseur_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "projet_id", referencedColumnName = "ID")
    private Projet projet;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "fournisseur_id", referencedColumnName = "ID")
    private Fournisseur fournisseur;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;
    
    public Projet_has_Fournisseur() {
    }
    
    public Projet_has_Fournisseur(int projet_id, int fournisseur_id, Projet projet, Fournisseur fournisseur) {
        this.projet_id = projet_id;
        this.fournisseur_id = fournisseur_id;
        this.projet = projet;
        this.fournisseur = fournisseur;
    }
    
    public Projet_has_Fournisseur(Projet projet, Fournisseur fournisseur) {
        this.projet = projet;
        this.fournisseur = fournisseur;
    }

    public Projet getProjet() {
        return this.projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getFonds() {
        return this.fonds;
    }

    public void setFonds(String fonds) {
        this.fonds = fonds;
    }
}
