package com.project.oumaimaproject.security.service;

import com.project.oumaimaproject.security.entities.AppRole;
import com.project.oumaimaproject.security.entities.AppUser;

public interface AccountService {

    AppUser addNewUser(String username, String password, String confirmPWD) ;
    AppRole addNewRole(String role) ;
    void addRoleToUser(String username, String role) ;

    void removeRoleFromUser(String username, String role) ;

    AppUser loadUserByUserName(String username) ;
}
