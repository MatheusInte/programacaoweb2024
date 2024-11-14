package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.UsuarioDTO;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElse(null);
    }

    @Override
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = converterParaEntidade(usuarioDTO);
        usuario = usuarioRepository.save(usuario);

        return converterParaDTO(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO converterParaDTO(Usuario usuario){
        return new UsuarioDTO(usuario.getNome(), usuario.getDataDeNascimento(),
                usuario.getEndereco(), usuario.getExperiencia(), usuario.getAulas());
    }

    private Usuario converterParaEntidade(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setDataDeNascimento(usuarioDTO.getDataDeNascimento());
        usuario.setEndereco(usuarioDTO.getEndereco());
        usuario.setExperiencia(usuarioDTO.getExperiencia());
        usuario.setAulas(usuarioDTO.getAulas());

        return usuario;
    }
}
