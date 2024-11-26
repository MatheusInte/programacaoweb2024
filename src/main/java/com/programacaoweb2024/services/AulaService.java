package com.programacaoweb2024.services;

import com.programacaoweb2024.DTOs.*;
import com.programacaoweb2024.entities.Aula;

import java.util.List;

public interface AulaService {
    public List<AulaResponseDTO> listarAulas();
    public AulaResponseDTO buscarAulaPorId(Long id);
    public  AulaResponseDTO cadastrarAula(AulaRequestDTO aulaRequestDTO);
    public AulaResponseDTO atualizarAula(AulaUpdateDTO aulaUpdateDTO);
    public UsuarioResponseDTO atribuirAulas(AulaAssignDTO aulaAssignDTO);
    public void deletarAula(Long id);
    public void deletarTodasAulas();
}
