/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "tp_personne")
@Access(AccessType.FIELD)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ENTITE")
@DiscriminatorValue("PERSONNE")

public class Personne implements Serializable {

    protected static final int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    protected int id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    protected String nom;

    public Personne() {
    }
    
    public Personne(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public Personne(String nom) {
        this.nom = nom;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
