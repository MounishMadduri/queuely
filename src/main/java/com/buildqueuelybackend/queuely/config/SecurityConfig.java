package com.buildqueuelybackend.queuely.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity  // enables @PreAuthorize
public class SecurityConfig {

    private final GoogleOAuth2SuccessHandler oAuth2SuccessHandler;

    public SecurityConfig(GoogleOAuth2SuccessHandler oAuth2SuccessHandler) {
        this.oAuth2SuccessHandler = oAuth2SuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()   // open endpoints
                        .anyRequest().authenticated()                // everything else secured
                )
                .oauth2Login(oauth -> oauth
                        .successHandler(oAuth2SuccessHandler)        // custom handler after Google login
                );

        return http.build();
    }
}
