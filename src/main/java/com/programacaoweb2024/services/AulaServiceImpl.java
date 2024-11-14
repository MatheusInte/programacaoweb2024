package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.AulaDTO;
import com.programacaoweb2024.DTOs.UsuarioDTO;
import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.entities.Usuario;
import com.programacaoweb2024.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AulaServiceImpl implements AulaService{

    @Autowired
    AulaRepository aulaRepository;

    @Override
    public List<AulaDTO> listarAulas() {
        return aulaRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Aula buscarAulaPorId(Long id) {
        Optional<Aula> obj = aulaRepository.findById(id);
        return obj.orElse(null);
    }

    @Override
    public AulaDTO cadastrarAula(AulaDTO aulaDTO) {
        Aula aula = converterParaEntidade(aulaDTO);
        aula = aulaRepository.save(aula);

        return converterParaDTO(aula);
    }

    @Override
    public void deletarAula(Long id) {
        aulaRepository.deleteById(id);
    }

    private AulaDTO converterParaDTO(Aula aula){
        return new AulaDTO(aula.getTitulo(), aula.getDescricao(),
                aula.getData(), aula.getTipoDeAula(), aula.getExercicios(), aula.getUsuario());
    }

    private Aula converterParaEntidade(AulaDTO aulaDTO){
        Aula aula = new Aula();

        aula.setTitulo(aulaDTO.getTitulo());
        aula.setDescricao(aulaDTO.getDescricao());
        aula.setData(aulaDTO.getData());
        aula.setTipoDeAula(aulaDTO.getTipoDeAula());
        aula.setExercicios(aulaDTO.getExercicios());
        aula.setUsuario(aulaDTO.getUsuario());

        return aula;
    }
}
