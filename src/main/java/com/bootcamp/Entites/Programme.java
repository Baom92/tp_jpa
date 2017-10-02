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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private static final int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    private String nom;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "objectif", length=45, nullable=false)
    private String objectif;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programme")
    private List<Projet> projets;
    
    @OneToOne(fetch = FetchType.LAZY)
    IndicateurPerformance indicateur_performance;
    
//    @ManyToMany
//    private List<Beneficiaire> beneficiaires;
    
    @OneToMany(mappedBy = "programme" , cascade = CascadeType.ALL)
    private List<Programme_has_Beneficiaire> beneficiaires ;
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "tp_programme_bailleur", joinColumns = @JoinColumn(name = "programme_id"), inverseJoinColumns = @JoinColumn(name = "bailleur_id"))
//    private List<Bailleur> bailleurs;
    
    @OneToMany(mappedBy = "programme" , cascade = CascadeType.ALL)
    private List<Bailleur_has_Programme> bailleurs ;
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "tp_programme_fournisseur", joinColumns = @JoinColumn(name = "programme_id"), inverseJoinColumns = @JoinColumn(name = "fournisseur_id"))
//    private List<Fournisseur> fournisseurs;
    
    @OneToMany(mappedBy = "programme" , cascade = CascadeType.ALL)
    private List<Programme_has_Fournisseur> fournisseurs ;
    
    public Programme() {
    }
    
    public Programme(int id, String nom, String objectif) {
        this.id = id;
        this.nom = nom;
        this.objectif = objectif;
    }
    
    public Programme(String nom, String objectif) {
        this.nom = nom;
        this.objectif = objectif;
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
    public List<Projet> getProjetList() {
        return projets;
    }

    public void setProjetList(List<Projet> projets) {
        this.projets = projets;
    }
    
    @XmlTransient
    public List<Programme_has_Beneficiaire> getBeneficiaireList() {
        return beneficiaires;
    }

    public void setBeneficiaireList(List<Programme_has_Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }
    
    @XmlTransient
    public List<Bailleur_has_Programme> getBailleurList() {
        return bailleurs;
    }

    public void setBailleurList(List<Bailleur_has_Programme> bailleurs) {
        this.bailleurs = bailleurs;
    }
    
    @XmlTransient
    public List<Programme_has_Fournisseur> getFournisseurList() {
        return fournisseurs;
    }

    public void setFournisseurList(List<Programme_has_Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
}
