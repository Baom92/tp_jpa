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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "tp_livrable")
@Access(AccessType.FIELD)

public class Livrable implements Serializable {

    private static final int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    private String nom;
    
    @ManyToOne
    @JoinColumn(name = "projet", referencedColumnName = "id", insertable=false, updatable=false)
    private Projet projet;
    @OneToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateur_performance;
    
    public Livrable() {
    }
    
    public Livrable(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public Livrable(String nom) {
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
        
    public IndicateurPerformance getIndicateurPerformance() {
        return indicateur_performance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateur_performance) {
        this.indicateur_performance = indicateur_performance;
    }
    
    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
