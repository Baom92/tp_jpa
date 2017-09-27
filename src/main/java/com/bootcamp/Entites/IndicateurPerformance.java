/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.Entites;

import java.io.Serializable;
import java.util.ArrayList;
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    private String nom;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="indicateur_performance")
    ArrayList<IndicateurQuantitatif> indic_quantitatif;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="indicateur_performance")
    ArrayList<IndicateurQualitatif> indic_qualitatif;
    
    public IndicateurPerformance() {
    }
    
    public IndicateurPerformance(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public IndicateurPerformance(String nom) {
        this.nom = nom;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @XmlTransient
    public ArrayList<IndicateurQualitatif> getIndicateurQualitatifList() {
        return indic_qualitatif;
    }

    public void setIndicateurQualitatifList(ArrayList<IndicateurQualitatif> indic_qualitatif) {
        this.indic_qualitatif = indic_qualitatif;
    }
    
    @XmlTransient
    public ArrayList<IndicateurQuantitatif> getIndicateurQuantitatifList() {
        return indic_quantitatif;
    }

    public void setIndicateurQuantitatifList(ArrayList<IndicateurQuantitatif> indic_quantitatif) {
        this.indic_quantitatif = indic_quantitatif;
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
        if (!(object instanceof IndicateurPerformance)) {
            return false;
        }
        IndicateurPerformance other = (IndicateurPerformance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.Entites.IndicateurPerformance[ id=" + id + " ]";
    }
}
