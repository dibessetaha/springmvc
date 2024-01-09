package com.project.oumaimaproject.repositories;

import com.project.oumaimaproject.model.Jardin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JardinRepository extends JpaRepository<Jardin, Long> {

    List<Jardin> findJardinByNomDuJardinContaining(String keyword) ;
}
