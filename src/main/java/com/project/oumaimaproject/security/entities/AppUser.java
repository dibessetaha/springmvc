package com.project.oumaimaproject.security.entities;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor @Data @NoArgsConstructor @Builder
public class AppUser {

    @Id
    private String userId ;
    @Column(unique = true)
    private String username ;
    private String password ;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles ;


}
