package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.UsuarioRequestDTO;
import com.programacaoweb2024.DTOs.UsuarioResponseDTO;
import com.programacaoweb2024.DTOs.UsuarioUpdateDTO;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsuarioResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.existsByemail(usuarioRequestDTO.email())){
            throw new IllegalArgumentException("O email já está em uso");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setDataDeNascimento(usuarioRequestDTO.dataDeNascimento());
        usuario.setEndereco(usuarioRequestDTO.endereco());
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setPassword(usuarioRequestDTO.password());
        usuario.setExperiencia(usuarioRequestDTO.experiencia());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuarioSalvo);
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO){
        Usuario usuario = usuarioRepository.findByEmail(usuarioUpdateDTO.email())
                .orElseThrow(() -> new IllegalArgumentException("Email não encontrado: " + usuarioUpdateDTO.email()));

        usuario.setNome(usuarioUpdateDTO.nome());
        usuario.setDataDeNascimento(usuarioUpdateDTO.dataDeNascimento());
        usuario.setEndereco(usuarioUpdateDTO.endereco());
        usuario.setEmail(usuarioUpdateDTO.email());
        usuario.setExperiencia(usuarioUpdateDTO.experiencia());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuarioAtualizado);
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void deletarTodosUsuarios(){
        usuarioRepository.deleteAll();
    }
}
