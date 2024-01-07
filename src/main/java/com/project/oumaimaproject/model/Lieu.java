package com.project.oumaimaproject.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lieu")
public class Lieu {


    @Id
    private String codeInsee;
    private String nomCom;
    private double longitude;
    private double latitude;

    @OneToMany(mappedBy = "codeLieu", cascade = CascadeType.ALL)
    private List<Monument> monuments = new ArrayList<Monument>();


    @ManyToOne(optional=false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="dep")
    public Departement dept;



    //Constructeurs
    public Lieu() {}


    public Lieu(String codeInsee, String nomCom, double longitude, double latitude, List<Monument> monuments,
                Departement dept) {
        super();
        this.codeInsee = codeInsee;
        this.nomCom = nomCom;
        this.longitude = longitude;
        this.latitude = latitude;
        this.monuments = monuments;
        this.dept = dept;

    }


    public String getCodeInsee() {
        return codeInsee;
    }


    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }


    public String getNomCom() {
        return nomCom;
    }


    public void setNomCom(String nomCom) {
        this.nomCom = nomCom;
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


    public List<Monument> getMonuments() {
        return monuments;
    }


    public void setMonuments(List<Monument> monuments) {
        this.monuments = monuments;
    }


    public Departement getDept() {
        return dept;
    }


    public void setDept(Departement dept) {
        this.dept = dept;
    }


}
