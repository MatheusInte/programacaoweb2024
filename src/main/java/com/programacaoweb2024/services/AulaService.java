package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.AulaRequestDTO;
import com.programacaoweb2024.DTOs.AulaResponseDTO;
import com.programacaoweb2024.entities.Aula;

import java.util.List;

public interface AulaService {
    public List<AulaResponseDTO> listarAulas();
    public AulaResponseDTO buscarAulaPorId(Long id);
    public  AulaResponseDTO cadastrarAula(AulaRequestDTO aulaRequestDTO);
    public void deletarAula(Long id);
    public void deletarTodasAulas();
}
