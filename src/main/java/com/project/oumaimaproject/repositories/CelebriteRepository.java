package com.project.oumaimaproject.repositories;

import com.project.oumaimaproject.model.Celebrite;
import com.project.oumaimaproject.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CelebriteRepository extends JpaRepository<Celebrite,String> {
    public List<Celebrite> findByNom(String nom) ;
    List<Celebrite> findByNomContainingOrPrenomContaining(String keyword1, String keyword2);

}
