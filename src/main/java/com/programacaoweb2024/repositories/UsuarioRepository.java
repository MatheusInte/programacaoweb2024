package com.programacaoweb2024.repositories;

import com.programacaoweb2024.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByemail(String email);

    boolean existsByEmail(@NotBlank(message = "Email é obrigatório") String email);
    //UserDetails findByEmail(String email);
}
