package com.boletim.service;

import com.boletim.dto.AvaliacaoRequest;
import com.boletim.dto.AvaliacaoResponse;
import com.boletim.model.Avaliacao;
import com.boletim.model.Disciplina;
import com.boletim.repository.AvaliacaoRepository;
import com.boletim.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final DisciplinaRepository disciplinaRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, DisciplinaRepository disciplinaRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<AvaliacaoResponse> listarTodo() {
        return avaliacaoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<AvaliacaoResponse> buscarId(Long id) {
        return avaliacaoRepository.findById(id)
                .map(this::toResponse);
    }

    public AvaliacaoResponse criar(AvaliacaoRequest dto) {
        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setTipo(dto.getTipo());
        avaliacao.setData(dto.getData());
        avaliacao.setPeso(dto.getPeso());
        avaliacao.setDisciplina(disciplina);

        Avaliacao salva = avaliacaoRepository.save(avaliacao);
        return toResponse(salva);
    }

    public Optional<AvaliacaoResponse> atualizar(Long id, AvaliacaoRequest dto) {
        return avaliacaoRepository.findById(id)
                .map(avaliacao -> {
                    Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                            .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

                    avaliacao.setTipo(dto.getTipo());
                    avaliacao.setData(dto.getData());
                    avaliacao.setPeso(dto.getPeso());
                    avaliacao.setDisciplina(disciplina);

                    Avaliacao atualizada = avaliacaoRepository.save(avaliacao);
                    return toResponse(atualizada);
                });
    }

    public boolean deletar(Long id) {
        return avaliacaoRepository.findById(id)
                .map(avaliacao -> {
                    avaliacaoRepository.delete(avaliacao);
                    return true;
                })
                .orElse(false);
    }

    private AvaliacaoResponse toResponse(Avaliacao avaliacao) {
        return new AvaliacaoResponse(
                avaliacao.getId(),
                avaliacao.getTipo(),
                avaliacao.getData(),
                avaliacao.getPeso(),
                avaliacao.getDisciplina().getId(),
                avaliacao.getDisciplina().getNome()
        );
    }
}