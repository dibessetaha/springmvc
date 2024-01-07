package com.project.oumaimaproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="celebrite")
public class Celebrite {
    @Id
    private int numCelebrite;
    private String nom;
    private String prenom;
    private String nationalite;
    private String epoque;

    @ManyToMany(mappedBy = "celebrites", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Monument> monuments;


    //constructeurs

    public Celebrite() {}
    public Celebrite(int numCelebrite, String nom, String prenom, String nationalite, String epoque,
                     List<Monument> monuments) {
        super();
        this.numCelebrite = numCelebrite;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.epoque = epoque;
        this.monuments = monuments;
    }
    public int getNumCelebrite() {
        return numCelebrite;
    }
    public void setNumCelebrite(int numCelebrite) {
        this.numCelebrite = numCelebrite;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNationalite() {
        return nationalite;
    }
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    public String getEpoque() {
        return epoque;
    }
    public void setEpoque(String epoque) {
        this.epoque = epoque;
    }
    public List<Monument> getMonuments() {
        return monuments;
    }
    public void setMonuments(List<Monument> monuments) {
        this.monuments = monuments;
    }






}
