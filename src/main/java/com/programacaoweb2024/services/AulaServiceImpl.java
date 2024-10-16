package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.repositories.AulaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService{

    @Autowired
    AulaRepository aulaRepository;

    @Override
    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public Aula buscarAulaPorId(Long id) {
        return aulaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Aula cadastrarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    @Transactional
    public Aula atualizarAula(Long id, Aula aula){
        Aula aulaAtualizada = aulaRepository.findById(aula.getId())
                .orElseThrow(() -> new EntityNotFoundException("Aula.java não encontrada"));

        aulaAtualizada.setTipoDeAula(aula.getTipoDeAula());
        aulaAtualizada.setId(aula.getId());
        aulaAtualizada.setData(aula.getData());
        aulaAtualizada.setTitulo(aula.getTitulo());
        aulaAtualizada.setDescricao(aula.getDescricao());
        aulaAtualizada.setExercicios(aula.getExercicios());

        return aulaRepository.save(aulaAtualizada);
    }

    @Override
    public void deletarAula(Long id) {
        aulaRepository.deleteById(id);
    }
}
