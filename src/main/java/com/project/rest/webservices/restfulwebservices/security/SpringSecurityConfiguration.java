package com.project.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.net.HttpCookie;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        http.httpBasic(Customizer.withDefaults());

        return http.build();

    }
}
