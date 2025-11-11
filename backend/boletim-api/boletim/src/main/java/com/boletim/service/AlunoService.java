package com.boletim.service;

import com.boletim.dto.AlunoRequest;
import com.boletim.dto.AlunoResponse;
import com.boletim.dto.TurmaResponse;
import com.boletim.exception.RecursoNaoEncontradoException;
import com.boletim.model.Aluno;
import com.boletim.model.Turma;
import com.boletim.repository.AlunoRepository;
import com.boletim.repository.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public AlunoService(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }


    public List<AlunoResponse> listarTodo() {
        return alunoRepository.findAll().stream().map(aluno -> {
            return new AlunoResponse(
                    aluno.getId(),
                    aluno.getNome(),
                    new TurmaResponse(aluno.getTurma())
            );
        }).collect(Collectors.toList());


    }

    public Optional<Aluno> buscarId(Long id) {
        return alunoRepository.findById(id);
    }

    public List<Aluno> listarTurma(Long turmaId) {
        return alunoRepository.findByTurmaId(turmaId);
    }

    public Aluno criar(@Valid AlunoRequest dto) {
        Turma turma = turmaRepository.findById(dto.getTurmaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Turma não encotrada"));

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setTurma(turma);

        return alunoRepository.save(aluno);
    }


    public Optional<Aluno> atualizar(Long id, @Valid AlunoRequest dto) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(dto.getNome());
                    Turma turma = turmaRepository.findById(dto.getTurmaId())
                                    .orElseThrow(() -> new RecursoNaoEncontradoException("Turma nao encontrada" + dto.getTurmaId()));
                    aluno.setTurma(turma);
                    return alunoRepository.save(aluno);
                });
    }

    public boolean deletar(Long id) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    alunoRepository.delete(aluno);
                    return true;
                })
                .orElse(false);
    }

    public AlunoResponse toResponse(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                new TurmaResponse(aluno.getTurma().getId(), aluno.getTurma().getNome())
        );
    }
}
