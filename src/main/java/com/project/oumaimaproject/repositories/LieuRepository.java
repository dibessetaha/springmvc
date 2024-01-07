package com.project.oumaimaproject.repositories;

import com.project.oumaimaproject.model.Lieu;
import com.project.oumaimaproject.model.Monument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LieuRepository extends JpaRepository<Lieu,String> {

    List<Lieu> findByNomComContaining(String keyword);
}
