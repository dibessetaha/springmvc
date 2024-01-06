package com.project.oumaimaproject.security;

import com.project.oumaimaproject.security.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private PasswordEncoder passwordEncoder ;
    private UserDetailsServiceImpl userDetailsServiceImpl ;

//    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
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
                        .requestMatchers(mvc.pattern("/signup")).permitAll()
                        .anyRequest().authenticated()

        ) ;

        httpSecurity.formLogin(e->
                e.loginPage("/signin").permitAll()
                        .defaultSuccessUrl("/acceuil")
                        .failureUrl("/nonAutoriser")
        );
        httpSecurity.userDetailsService(userDetailsServiceImpl);
        httpSecurity.exceptionHandling((exp)->exp.accessDeniedPage("/nonAutoriser"));
        return httpSecurity.build() ;

    }


}
