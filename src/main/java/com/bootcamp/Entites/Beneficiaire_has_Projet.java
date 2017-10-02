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
@Table(name = "tp_beneficiaire_has_projet")
@Access(AccessType.FIELD)
//@IdClass(Beneficiaire_has_Projet.class)

public class Beneficiaire_has_Projet implements Serializable {

    @Id
    @Column(name = "beneficiaire_id", nullable=false)
    private int beneficiaire_id;

    @Id
    @Column(name = "projet_id", nullable=false)
    private int projet_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "beneficiaire_id", referencedColumnName = "ID")
    private Beneficiaire beneficiaire;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "projet_id", referencedColumnName = "ID")
    private Projet projet;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;
    
    public Beneficiaire_has_Projet() {
    }
    
    public Beneficiaire_has_Projet(int beneficiaire_id, int projet_id, Beneficiaire beneficiaire, Projet projet) {
        this.beneficiaire_id = beneficiaire_id;
        this.projet_id = projet_id;
        this.beneficiaire = beneficiaire;
        this.projet = projet;
    }
    
    public Beneficiaire_has_Projet(Beneficiaire beneficiaire, Projet projet) {
        this.beneficiaire = beneficiaire;
        this.projet = projet;
    }

    public Beneficiaire getBeneficiaire() {
        return this.beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getFonds() {
        return this.fonds;
    }

    public void setFonds(String fonds) {
        this.fonds = fonds;
    }
}
