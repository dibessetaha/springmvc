package com.project.oumaimaproject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "jardin")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Jardin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_du_jardin")
    private String nomDuJardin;

    @Column(name = "commune")
    private String commune;


    @Column(name = "adresse")
    private String adresseComplete;

    @Column(name = "type")
    private String type ;

    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private String dateDeCreation;

    @ManyToOne(optional=false)
    @JoinColumn(name="codeInsee")
    private Lieu codeLieu;



}
