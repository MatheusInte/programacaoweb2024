package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.RegisterRequestDTO;
import com.programacaoweb2024.DTOs.UsuarioRequestDTO;
import com.programacaoweb2024.DTOs.UsuarioResponseDTO;
import com.programacaoweb2024.DTOs.UsuarioUpdateDTO;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.exceptions.*;
import com.programacaoweb2024.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        if(usuarioRequestDTO.nome() == null || usuarioRequestDTO.nome().isBlank()){
            throw new UsuarioNomeException();
        }
        if(usuarioRequestDTO.dataDeNascimento() == null || usuarioRequestDTO.dataDeNascimento().toString().isBlank()){
            throw new UsuarioDataException();
        }
        if(usuarioRequestDTO.endereco() == null || usuarioRequestDTO.endereco().isBlank()){
            throw new UsuarioEnderecoException();
        }
        if(usuarioRequestDTO.email() == null || usuarioRequestDTO.email().isBlank()){
            throw new UsuarioEmailException();
        }
        if(usuarioRequestDTO.password() == null || usuarioRequestDTO.password().isBlank()){
            throw new UsuarioPasswordException();
        }
        if(usuarioRequestDTO.experiencia() == null || usuarioRequestDTO.experiencia().toString().isBlank()){
            throw new UsuarioExperienciaException();
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

    public Usuario registrarUsuario(RegisterRequestDTO request) {
        // Verificar se o email já está em uso
        if (usuarioRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email já está em uso.");
        }

        // Criar novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(request.nome());
        novoUsuario.setDataDeNascimento(request.dataDeNascimento());
        novoUsuario.setExperiencia(request.experiencia());
        novoUsuario.setEmail(request.email());
        novoUsuario.setPassword(passwordEncoder.encode(request.password()));
        novoUsuario.setRole(request.role());

        // Salvar no banco
        return usuarioRepository.save(novoUsuario);
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
