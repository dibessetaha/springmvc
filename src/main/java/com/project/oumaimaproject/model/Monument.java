package com.project.oumaimaproject.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="monument")
public class Monument {

    @Id
    private String geohash;
    private String nom;
    private String proprietaire;
    @Column( name= "typeM")
    private String typeMonument;
    private double longitude;
    private double latitude;

    public List<Celebrite> getCelebrites() {
        return celebrites;
    }




    @ManyToOne
    @JoinColumn(name="codeInsee")
    private Lieu codeLieu;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="associea",
            joinColumns= @JoinColumn(name="codeM"),
            inverseJoinColumns=@JoinColumn(name="numCelebrite"))
    private List<Celebrite> celebrites = new ArrayList<Celebrite>();

    //Construcleurs

    public Monument() {};

    public Monument(String geohash, String nom, String proprietaire, String typeMonument, double longitude,
                    double latitude, Lieu codeLieu) {
        super();
        this.geohash = geohash;
        this.nom = nom ;
        this.proprietaire = proprietaire;
        this.typeMonument = typeMonument;
        this.longitude = longitude;
        this.latitude = latitude;
        this.codeLieu = codeLieu;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getTypeMonument() {
        return typeMonument;
    }

    public void setTypeMonument(String typeMonument) {
        this.typeMonument = typeMonument;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Lieu getCodeLieu() {
        return codeLieu;
    }

    public void setCodeLieu(Lieu codeLieu) {
        this.codeLieu = codeLieu;
    }

    public void setCelebrites(List<Celebrite> celebrites) {
        this.celebrites = celebrites;
    }








}
