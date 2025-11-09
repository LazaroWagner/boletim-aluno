package com.boletim.service;

import com.boletim.dto.TurmaRequest;
import com.boletim.dto.TurmaResponse;
import com.boletim.model.Turma;
import com.boletim.repository.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<TurmaResponse> listarToda() {
        return turmaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<TurmaResponse> buscarId(Long id) {
        return turmaRepository.findById(id)
                .map(this::toResponse);
    }

    public TurmaResponse criar(TurmaRequest dto) {
        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        Turma salve = turmaRepository.save(turma);
        return toResponse(salve);
    }

    public Optional<TurmaResponse> atualizar(Long id, TurmaRequest dto) {
        return turmaRepository.findById(id)
                .map(turma -> {
                    turma.setNome(dto.getNome());
                    Turma atualizada = turmaRepository.save(turma);
                    return toResponse(atualizada);
                });
    }

    public boolean deletar(Long id) {
        return turmaRepository.findById(id)
                .map(turma -> {
                    turmaRepository.delete(turma);
                    return true;
                })
                .orElse(false);
    }

    private TurmaResponse toResponse(Turma turma) {
        return new TurmaResponse(turma.getId(), turma.getNome());
    }

}
