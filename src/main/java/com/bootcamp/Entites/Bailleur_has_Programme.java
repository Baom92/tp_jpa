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
@Table(name = "tp_bailleur_has_programme")
@Access(AccessType.FIELD)
//@IdClass(Bailleur_has_Programme.class)

public class Bailleur_has_Programme implements Serializable {

    @Id
    @Column(name = "bailleur_id", nullable=false)
    private int bailleur_id;

    @Id
    @Column(name = "programme_id", nullable=false)
    private int programme_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "bailleur_id", referencedColumnName = "ID")
    private Bailleur bailleur;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "programme_id", referencedColumnName = "ID")
    private Programme programme;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;
    
    public Bailleur_has_Programme() {
    }
    
    public Bailleur_has_Programme(int bailleur_id, int programme_id, Bailleur bailleur, Programme programme) {
        this.bailleur_id = bailleur_id;
        this.programme_id = programme_id;
        this.bailleur = bailleur;
        this.programme = programme;
    }
    
    public Bailleur_has_Programme(Bailleur bailleur, Programme programme) {
        this.bailleur = bailleur;
        this.programme = programme;
    }

    public Bailleur getBailleur() {
        return this.bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public String getFonds() {
        return this.fonds;
    }

    public void setFonds(String fonds) {
        this.fonds = fonds;
    }
}
