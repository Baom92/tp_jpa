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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "tp_programme")
@Access(AccessType.FIELD)

public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    private String nom;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "objectif", length=45, nullable=false)
    private String objectif;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programme")
    private ArrayList<Projet> projets;
    
    @OneToOne(fetch = FetchType.LAZY)
    IndicateurPerformance indicateur_performance;
    
    @ManyToMany
    private ArrayList<Beneficiaire> beneficiaires;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tp_programme_bailleur", joinColumns = @JoinColumn(name = "programme_id"), inverseJoinColumns = @JoinColumn(name = "bailleur_id"))
    private ArrayList<Bailleur> bailleurs;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tp_programme_fournisseur", joinColumns = @JoinColumn(name = "programme_id"), inverseJoinColumns = @JoinColumn(name = "fournisseur_id"))
    private ArrayList<Fournisseur> fournisseurs;
    
    public Programme() {
    }
    
    public Programme(long id, String nom, String objectif) {
        this.id = id;
        this.nom = nom;
        this.objectif = objectif;
    }
    
    public Programme(String nom, String objectif) {
        this.nom = nom;
        this.objectif = objectif;
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
    
    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
    
    public IndicateurPerformance getIndicateurPerformance() {
        return indicateur_performance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateur_performance) {
        this.indicateur_performance = indicateur_performance;
    }
    
    @XmlTransient
    public ArrayList<Projet> getProjetList() {
        return projets;
    }

    public void setProjetList(ArrayList<Projet> projets) {
        this.projets = projets;
    }
    
    @XmlTransient
    public ArrayList<Beneficiaire> getBeneficiaireList() {
        return beneficiaires;
    }

    public void setBeneficiaireList(ArrayList<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }
    
    @XmlTransient
    public ArrayList<Bailleur> getBailleurList() {
        return bailleurs;
    }

    public void setBailleurList(ArrayList<Bailleur> bailleurs) {
        this.bailleurs = bailleurs;
    }
    
    @XmlTransient
    public ArrayList<Fournisseur> getFournisseurList() {
        return fournisseurs;
    }

    public void setFournisseurList(ArrayList<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
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
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.Entites.Programme[ id=" + id + " ]";
    }
}
