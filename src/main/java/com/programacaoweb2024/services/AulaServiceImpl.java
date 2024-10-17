package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Aula;
import com.programacaoweb2024.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Aula> obj = aulaRepository.findById(id);
        return obj.orElse(null);
    }

    @Override
    public Aula cadastrarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public void deletarAula(Long id) {
        aulaRepository.deleteById(id);
    }
}
