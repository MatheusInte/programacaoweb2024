package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.UsuarioRequestDTO;
import com.programacaoweb2024.DTOs.UsuarioResponseDTO;
import com.programacaoweb2024.DTOs.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioResponseDTO> listarUsuarios();
    public UsuarioResponseDTO buscarUsuarioPorId(Long id);
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO);
    public UsuarioResponseDTO atualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO);
    public void deletarUsuario(Long id);
    public void deletarTodosUsuarios();
}
