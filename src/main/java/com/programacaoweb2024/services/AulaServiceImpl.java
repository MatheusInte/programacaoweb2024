package com.programacaoweb2024.services;


import com.programacaoweb2024.DTOs.*;
import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.repositories.AulaRepository;
import com.programacaoweb2024.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AulaServiceImpl implements AulaService{

    @Autowired
    AulaRepository aulaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<AulaResponseDTO> listarAulas() {
        List<Aula> aulas = aulaRepository.findAll();
        return aulas.stream()
                .map(AulaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public AulaResponseDTO buscarAulaPorId(Long id) {
        Aula aula = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));
        return new AulaResponseDTO(aula);
    }

    @Override
    public AulaResponseDTO cadastrarAula(AulaRequestDTO aulaRequestDTO) {
        LocalTime horario = aulaRequestDTO.horario();
        if (horario.isBefore(LocalTime.of(6,0)) || horario.isAfter(LocalTime.of(21,0))){
            throw new IllegalArgumentException("O horário da aula deve ser entre 06:00 e 21:00");
        }

        Aula aula = new Aula();
        aula.setTitulo(aulaRequestDTO.titulo());
        aula.setDescricao(aulaRequestDTO.descricao());
        aula.setData(aulaRequestDTO.data());
        aula.setHorario(aulaRequestDTO.horario());
        aula.setTipoDeAula(aulaRequestDTO.tipoDeAula());

        Aula aulaSalva = aulaRepository.save(aula);

        return new AulaResponseDTO(aulaSalva);
    }

    @Override
    public AulaResponseDTO atualizarAula(AulaUpdateDTO aulaUpdateDTO){
        Aula aula = aulaRepository.findById(aulaUpdateDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Aula de ID: " + aulaUpdateDTO.id() + "Não encontrada"));

        aula.setTitulo(aulaUpdateDTO.titulo());
        aula.setDescricao(aulaUpdateDTO.descricao());
        aula.setData(aulaUpdateDTO.data());
        aula.setHorario(aulaUpdateDTO.horario());
        aula.setTipoDeAula(aulaUpdateDTO.tipoDeAula());

        Aula aulaAtualizado = aulaRepository.save(aula);

        return new AulaResponseDTO(aulaAtualizado);
    }

    @Override
    public UsuarioResponseDTO atribuirAulas(AulaAssignDTO aulaAssignDTO){
        Usuario usuario = usuarioRepository.findById(aulaAssignDTO.usuarioId())
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        List<Aula> aulas = aulaRepository.findAllById(aulaAssignDTO.aulasId());

        if (aulas.isEmpty()){
            throw new RuntimeException("Aula não encontrada para o Id passado");
        }
        for (Aula aula : aulas){
            aula.setUsuario(usuario);
        }

        aulaRepository.saveAll(aulas);

        return new UsuarioResponseDTO(usuario);
    }

    @Override
    public void deletarAula(Long id) {
        aulaRepository.deleteById(id);
    }

    @Override
    public void deletarTodasAulas(){
        aulaRepository.deleteAll();
    }
}
