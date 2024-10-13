package com.programacaoweb2024.services;

import com.programacaoweb2024.entities.Aula;

import java.util.List;

public interface AulaService {
    public List<Aula> listarAulas();
    public Aula buscarAulaPorId(Long id);
    public Aula cadastrarAula(Aula aula);
    public void deletarAula(Long id);
}
