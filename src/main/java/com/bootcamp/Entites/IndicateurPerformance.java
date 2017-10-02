/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "tp_indicateur_performance")
@Access(AccessType.FIELD)

public class IndicateurPerformance implements Serializable {

    private static final int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    private String nom;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="indicateur_performance")
    List<IndicateurQuantitatif> indic_quantitatif;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="indicateur_performance")
    List<IndicateurQualitatif> indic_qualitatif;
    
    public IndicateurPerformance() {
    }
    
    public IndicateurPerformance(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public IndicateurPerformance(String nom) {
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
    
    @XmlTransient
    public List<IndicateurQualitatif> getIndicateurQualitatifList() {
        return indic_qualitatif;
    }

    public void setIndicateurQualitatifList(List<IndicateurQualitatif> indic_qualitatif) {
        this.indic_qualitatif = indic_qualitatif;
    }
    
    @XmlTransient
    public List<IndicateurQuantitatif> getIndicateurQuantitatifList() {
        return indic_quantitatif;
    }

    public void setIndicateurQuantitatifList(List<IndicateurQuantitatif> indic_quantitatif) {
        this.indic_quantitatif = indic_quantitatif;
    }
}
