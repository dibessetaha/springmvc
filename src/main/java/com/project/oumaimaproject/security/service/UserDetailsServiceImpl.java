package com.project.oumaimaproject.security.service;

import com.project.oumaimaproject.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountService accountService ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = accountService.loadUserByUserName(username) ;
        if(appUser==null) throw new UsernameNotFoundException(String.format("L'utilisateur %s n'existe pas",username)) ;

        return User.withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(appUser.getRoles().stream().map(u->u.getRole()).toArray(String[]::new))
                .build();
    }
}
