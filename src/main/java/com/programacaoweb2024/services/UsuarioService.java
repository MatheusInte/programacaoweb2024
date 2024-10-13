package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorId(Long id);
    public Usuario cadastrarUsuario(Usuario usuario);
    public void deletarUsuario(Long id);
}
