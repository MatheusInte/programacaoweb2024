package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.AulaDTO;
import com.programacaoweb2024.entities.Aula;

import java.util.List;

public interface AulaService {
    public List<AulaDTO> listarAulas();
    public Aula buscarAulaPorId(Long id);
    public AulaDTO cadastrarAula(AulaDTO aulaDTO);
    public void deletarAula(Long id);
}
