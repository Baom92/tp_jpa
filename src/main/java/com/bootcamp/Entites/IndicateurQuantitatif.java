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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "tp_indicateur_quantitatif")
@Access(AccessType.FIELD)

public class IndicateurQuantitatif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    private String nom;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "propriete", length=45, nullable=false)
    private String propriete;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "valeur", nullable=false)
    private int valeur;
    
    @ManyToOne
    @JoinColumn(name = "indicateur_performance", referencedColumnName = "id", insertable=false, updatable=false)
    IndicateurPerformance indicateur_performance;
    
    public IndicateurQuantitatif() {
    }
    
    public IndicateurQuantitatif(long id, String nom, String propriete, int valeur) {
        this.id = id;
        this.nom = nom;
        this.propriete = propriete;
        this.valeur = valeur;
    }
    
    public IndicateurQuantitatif(String nom, String propriete, int valeur) {
        this.nom = nom;
        this.propriete = propriete;
        this.valeur = valeur;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPropriete() {
        return propriete;
    }

    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }
    
    public IndicateurPerformance getIndicateurPerformance() {
        return indicateur_performance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateur_performance) {
        this.indicateur_performance = indicateur_performance;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicateurQuantitatif)) {
            return false;
        }
        IndicateurQuantitatif other = (IndicateurQuantitatif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.Entites.IndicateurQuantitatif[ id=" + id + " ]";
    }
}
