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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tp_projet")
@Access(AccessType.FIELD)
public class Projet implements Serializable {

    private static final int serialVersionUID = 1;
    @Id
    @Column(name = "id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "nom", length=45, nullable=false)
    private String nom;
    
    @NotNull(message="La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "objectif", length=45, nullable=false)
    private String objectif;
    
    @OneToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateur_performance;
    
    @ManyToOne
    @JoinColumn(name = "programme", referencedColumnName = "id")
    private Programme programme;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projet")
    private List<Livrable> livrables;
    
//    @ManyToMany
//    private List<Bailleur> bailleurs ;
    
    @OneToMany(mappedBy = "projet" , cascade = CascadeType.ALL)
    private List<Bailleur_has_Projet> bailleurs ;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "tp_projet_beneficiaire",joinColumns = @JoinColumn(name = "projet_id"),inverseJoinColumns = @JoinColumn(name = "beneficiaire_id"))
//    private List<Beneficiaire> beneficiaires;
    
    @OneToMany(mappedBy = "projet" , cascade = CascadeType.ALL)
    private List<Beneficiaire_has_Projet> beneficiaires ;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "tp_projet_fournisseur",joinColumns = @JoinColumn(name = "projet_id"),inverseJoinColumns = @JoinColumn(name = "fournisseur_id"))
//    private List<Fournisseur> fournisseurs;
    
    @OneToMany(mappedBy = "projet" , cascade = CascadeType.ALL)
    private List<Projet_has_Fournisseur> fournisseurs ;

    public Projet() {
    }
    
    public Projet(int id, String nom, String objectif) {
        this.id = id;
        this.nom = nom;
        this.objectif = objectif;
    }
    
    public Projet(String nom, String objectif) {
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
    
    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }
    
    @XmlTransient
    public List<Bailleur_has_Projet> getBailleurList() {
        return bailleurs;
    }

    public void setBailleurList(List<Bailleur_has_Projet> bailleurs) {
        this.bailleurs = bailleurs;
    }
    
    @XmlTransient
    public List<Beneficiaire_has_Projet> getBeneficiaireList() {
        return beneficiaires;
    }

    public void setBeneficiaireList(List<Beneficiaire_has_Projet> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }
    
    @XmlTransient
    public List<Projet_has_Fournisseur> getFournisseurList() {
        return fournisseurs;
    }

    public void setFournisseurList(List<Projet_has_Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
}
