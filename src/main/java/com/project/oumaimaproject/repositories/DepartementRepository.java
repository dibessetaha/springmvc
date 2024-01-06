package com.project.oumaimaproject.repositories;

import com.project.oumaimaproject.model.Departement;
import com.project.oumaimaproject.model.Lieu;
import com.project.oumaimaproject.model.Monument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement,String> {

}
