package com.project.oumaimaproject.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/nonAutoriser")
    public String notAuthorized(){
        return "403" ;
    }
}
