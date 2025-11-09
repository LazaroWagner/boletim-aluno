package com.boletim.service;

import com.boletim.model.Turma;
import com.boletim.repository.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> listarToda() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarId(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma criar(@Valid Turma turma) {
        return turmaRepository.save(turma);
    }

    public Optional<Turma> atualizar(Long id, @Valid Turma turmaAtualizada) {
        return turmaRepository.findById(id)
                .map(turma -> {
                    turma.setNome(turmaAtualizada.getNome());
                    return turmaRepository.save(turma);
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
}
