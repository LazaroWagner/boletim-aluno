package com.boletim.service;

import com.boletim.dto.DisciplinaRequest;
import com.boletim.dto.DisciplinaResponse;
import com.boletim.model.Disciplina;
import com.boletim.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaResponse> listarTodos() {
        return disciplinaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<DisciplinaResponse> buscarId(Long id) {
        return disciplinaRepository.findById(id)
                .map(this::toResponse);
    }

    public DisciplinaResponse criar(DisciplinaRequest dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        Disciplina salva = disciplinaRepository.save(disciplina);
        return toResponse(salva);
    }

    public Optional<DisciplinaResponse> atualizar(Long id, DisciplinaRequest dto) {
        return disciplinaRepository.findById(id)
                .map(disciplina -> {
                    disciplina.setNome(dto.getNome());
                    Disciplina atualizada = disciplinaRepository.save(disciplina);
                    return toResponse(atualizada);
                });
    }

    public boolean deletar(Long id) {
        return disciplinaRepository.findById(id)
                .map(disciplina -> {
                    disciplinaRepository.delete(disciplina);
                    return true;
                })
                .orElse(false);
    }

    private DisciplinaResponse toResponse(Disciplina disciplina) {
        return new DisciplinaResponse(disciplina.getId(), disciplina.getNome());
    }
}