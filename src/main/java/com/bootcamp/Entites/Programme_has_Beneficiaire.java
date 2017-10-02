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
@Table(name = "tp_programme_has_beneficiaire")
@Access(AccessType.FIELD)
//@IdClass(Programme_has_Beneficiaire.class)

public class Programme_has_Beneficiaire implements Serializable {

    @Id
    @Column(name = "programme_id", nullable=false)
    private int programme_id;

    @Id
    @Column(name = "beneficiaire_id", nullable=false)
    private int beneficiaire_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "programme_id", referencedColumnName = "ID")
    private Programme programme;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "beneficiaire_id", referencedColumnName = "ID")
    private Beneficiaire beneficiaire;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;
    
    public Programme_has_Beneficiaire() {
    }
    
    public Programme_has_Beneficiaire(int programme_id, int beneficiaire_id, Programme programme, Beneficiaire beneficiaire) {
        this.programme_id = programme_id;
        this.beneficiaire_id = beneficiaire_id;
        this.programme = programme;
        this.beneficiaire = beneficiaire;
    }
    
    public Programme_has_Beneficiaire(Programme programme, Beneficiaire beneficiaire) {
        this.programme = programme;
        this.beneficiaire = beneficiaire;
    }

    public Programme getProgramme() {
        return this.programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public String getFonds() {
        return this.fonds;
    }

    public void setFonds(String fonds) {
        this.fonds = fonds;
    }
}
