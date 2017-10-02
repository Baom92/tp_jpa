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
@Table(name = "tp_programme_has_fournisseur")
@Access(AccessType.FIELD)
//@IdClass(Programme_has_Fournisseur.class)

public class Programme_has_Fournisseur implements Serializable {

    @Id
    @Column(name = "programme_id", nullable=false)
    private int programme_id;

    @Id
    @Column(name = "fournisseur_id", nullable=false)
    private int fournisseur_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "programme_id", referencedColumnName = "ID")
    private Programme programme;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "fournisseur_id", referencedColumnName = "ID")
    private Fournisseur fournisseur;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;
    
    public Programme_has_Fournisseur() {
    }
    
    public Programme_has_Fournisseur(int programme_id, int fournisseur_id, Programme programme, Fournisseur fournisseur) {
        this.programme_id = programme_id;
        this.fournisseur_id = fournisseur_id;
        this.programme = programme;
        this.fournisseur = fournisseur;
    }
    
    public Programme_has_Fournisseur(Programme programme, Fournisseur fournisseur) {
        this.programme = programme;
        this.fournisseur = fournisseur;
    }

    public Programme getProgramme() {
        return this.programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
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
