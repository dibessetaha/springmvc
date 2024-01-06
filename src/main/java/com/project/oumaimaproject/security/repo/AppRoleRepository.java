package com.project.oumaimaproject.security.repo;

import com.project.oumaimaproject.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
