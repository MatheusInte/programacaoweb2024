package com.programacaoweb2024.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/usuarios/cadastrar").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/usuarios/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuarios/deletar/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuarios/deletar").hasRole("ADMIN")
                        .requestMatchers("/api/usuarios/registrar").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/aulas").hasRole("ALUNO")
                        .requestMatchers(HttpMethod.GET, "/api/aulas/{id}").hasRole("ALUNO")
                        .requestMatchers(HttpMethod.POST, "/api/aulas/cadastrar").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/aulas/atribuir").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/aulas/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/aulas/deletar/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/aulas/deletar").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/exercicios").hasRole("ALUNO")
                        .requestMatchers(HttpMethod.GET, "/api/exercicios/{id}").hasRole("ALUNO")
                        .requestMatchers(HttpMethod.POST, "/api/exercicios/cadastrar").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/exercicios/atribuir").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/exercicios/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/exercicios/deletar/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/exercicios/deletar").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
}
