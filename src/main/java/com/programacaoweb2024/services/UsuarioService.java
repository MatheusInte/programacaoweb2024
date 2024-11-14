package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.UsuarioDTO;
import com.programacaoweb2024.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioDTO> listarUsuarios();
    public Usuario buscarUsuarioPorId(Long id);
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO);
    public void deletarUsuario(Long id);
}
