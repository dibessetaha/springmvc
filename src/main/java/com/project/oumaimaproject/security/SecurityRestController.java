package com.project.oumaimaproject.security;

import jakarta.security.auth.message.config.AuthConfig;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecurityRestController {

    @GetMapping("/profile")
    public Principal authentication(Principal authentication){
        return authentication ;
    }
}
