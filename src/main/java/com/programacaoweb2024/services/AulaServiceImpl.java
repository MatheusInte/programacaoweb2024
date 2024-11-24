package com.programacaoweb2024.services;


import com.programacaoweb2024.DTOs.AulaRequestDTO;
import com.programacaoweb2024.DTOs.AulaResponseDTO;
import com.programacaoweb2024.DTOs.UsuarioResponseDTO;
import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AulaServiceImpl implements AulaService{

    @Autowired
    AulaRepository aulaRepository;

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

        Aula aulaSalva = aulaRepository.save(aula);

        return new AulaResponseDTO(aulaSalva);
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
