package com.project.oumaimaproject.security.repo;

import com.project.oumaimaproject.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {

    public AppUser findByUsername(String username) ;
}
