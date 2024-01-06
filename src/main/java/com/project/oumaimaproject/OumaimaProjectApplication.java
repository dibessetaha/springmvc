package com.project.oumaimaproject;

import com.project.oumaimaproject.model.Lieu;
import com.project.oumaimaproject.model.Monument;
import com.project.oumaimaproject.repositories.LieuRepository;
import com.project.oumaimaproject.repositories.MonumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class OumaimaProjectApplication  {


    public static void main(String[] args) {
        SpringApplication.run(OumaimaProjectApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder() ;
    }


}
