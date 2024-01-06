package com.project.oumaimaproject.security.service;

import com.project.oumaimaproject.security.entities.AppRole;
import com.project.oumaimaproject.security.entities.AppUser;
import com.project.oumaimaproject.security.repo.AppRoleRepository;
import com.project.oumaimaproject.security.repo.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    public AppUserRepository appUserRepository ;
    public AppRoleRepository appRoleRepository ;
    private PasswordEncoder passwordEncoder ;
    @Override
    public AppUser addNewUser(String username, String password, String confirmPWD) {
        AppUser appUser = appUserRepository.findByUsername(username) ;
        if(appUser!=null) throw new RuntimeException("L'utilisateur existe déjà") ;
        if(!password.equals(confirmPWD)) throw new RuntimeException("Le mot de passe ne correspond pas.");
        appUser = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();

        appUserRepository.save(appUser) ;
        return appUser;
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = appRoleRepository.findById(role).orElse(null) ;
        if(appRole!=null) throw new RuntimeException("Role existe déjà") ;

        appRole = AppRole.builder().role(role).build() ;
        return appRoleRepository.save(appRole) ;

    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username) ;
        AppRole appRole = appRoleRepository.findById(role).get() ;
        appUser.getRoles().add(appRole) ;

    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username) ;
        AppRole appRole = appRoleRepository.findById(role).get() ;
        appUser.getRoles().remove(appRole) ;
    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }
}
