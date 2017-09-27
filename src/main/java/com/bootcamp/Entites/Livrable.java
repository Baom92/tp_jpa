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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;
    
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
    
    public Livrable(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public Livrable(String nom) {
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livrable)) {
            return false;
        }
        Livrable other = (Livrable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.Entites.Livrable[ id=" + id + " ]";
    }
}
