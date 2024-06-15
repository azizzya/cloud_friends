package com.cloudcom2024.store.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests
                        .requestMatchers("/register").hasRole("ADMIN")
                        .requestMatchers("/store/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/chat/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/tasks/**", "/tasks/details/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/messages/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/tamagothi").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/personalities").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(
                            "/swagger-ui/**",
                            "v3/api-docs/**"
                        )
                        .permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .build();
    }
}
