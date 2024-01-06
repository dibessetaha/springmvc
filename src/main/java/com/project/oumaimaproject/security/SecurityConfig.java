package com.project.oumaimaproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        return new InMemoryUserDetailsManager(
                User.withUsername("oumaima").password(passwordEncoder.encode("1111")).roles("USER").build(),
                User.withUsername("taha").password(passwordEncoder.encode("1111")).roles("ADMIN","USER").build(),
                User.withUsername("amine").password(passwordEncoder.encode("1111")).roles("USER").build()


        );
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity, MvcRequestMatcher.Builder mvc) throws Exception {

        httpSecurity.authorizeHttpRequests(
                e-> e
                        .requestMatchers(mvc.pattern("/admin/**")).hasRole("ADMIN")
                        .requestMatchers(mvc.pattern("/user/**")).hasRole("USER")
                        .requestMatchers(mvc.pattern("/landing")).permitAll()
                        .anyRequest().authenticated()

        ) ;
        httpSecurity.formLogin(Customizer.withDefaults()) ;
        httpSecurity.exceptionHandling((exp)->exp.accessDeniedPage("/nonAutoriser"));
        return httpSecurity.build() ;

    }


}
