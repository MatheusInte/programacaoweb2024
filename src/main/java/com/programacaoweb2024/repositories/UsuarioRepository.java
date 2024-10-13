package com.programacaoweb2024.repositories;

import com.programacaoweb2024.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
