package com.project.oumaimaproject.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departement")
public class Departement {

    @Id
    private String dep;

    @Column(name = "nomDep")
    private String nomDep;

    @OneToOne
    @JoinColumn(name = "chefLieu")
    private Lieu chefLieu;

    @Column(name = "numReg")
    private String numReg;

    @OneToMany(targetEntity = Lieu.class, mappedBy = "dept", cascade = CascadeType.ALL)
    private List<Lieu> lieux = new ArrayList<>();

    // Constructeurs
    public Departement() {
    }

    public Departement(String dep, String nomDep, Lieu chefLieu, String numReg, List<Lieu> lieux) {
        this.dep = dep;
        this.nomDep = nomDep;
        this.chefLieu = chefLieu;
        this.numReg = numReg;
        this.lieux = lieux;
    }

    // Getters et Setters
    public String getDep() {
        return dep;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public Lieu getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(Lieu chefLieu) {
        this.chefLieu = chefLieu;
    }

    public String getNumReg() {
        return numReg;
    }

    public void setNumReg(String numReg) {
        this.numReg = numReg;
    }

    public List<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(List<Lieu> lieux) {
        this.lieux = lieux;
    }

    public void setDep(String dep) {
        this.dep = dep ;
    }
}
