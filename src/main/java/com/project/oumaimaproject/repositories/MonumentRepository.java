package com.project.oumaimaproject.repositories;

import com.project.oumaimaproject.model.Celebrite;
import com.project.oumaimaproject.model.Monument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MonumentRepository extends JpaRepository<Monument,String> {

    Page<Monument> findByNomContains(String keyword, Pageable pageable) ;

    @Query("SELECT m.celebrites FROM Monument m WHERE m.geohash = :geohash")
    List<Celebrite> findCelebritiesByMonumentGeohash(@Param("geohash") String geohash);
}
