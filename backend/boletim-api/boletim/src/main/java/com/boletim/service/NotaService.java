package com.boletim.service;

import com.boletim.dto.*;
import com.boletim.model.Aluno;
import com.boletim.model.Avaliacao;
import com.boletim.model.Nota;
import com.boletim.model.Turma;
import com.boletim.repository.AlunoRepository;
import com.boletim.repository.AvaliacaoRepository;
import com.boletim.repository.NotaRepository;
import com.boletim.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    private final TurmaRepository turmaRepository;

    public NotaService(NotaRepository notaRepository, AlunoRepository alunoRepository,
                       AvaliacaoRepository avaliacaoRepository, TurmaRepository turmaRepository) {
        this.notaRepository = notaRepository;
        this.alunoRepository = alunoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
        this.turmaRepository = turmaRepository;
    }

    public List<NotaResponse> listarTodo() {
        return notaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public NotaResponse criar(NotaRequest dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        Turma turma = turmaRepository.findById(dto.getTurmaId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Nota nota = new Nota();
        nota.setAluno(aluno);
        nota.setAvaliacao(avaliacao);
        nota.setTurma(turma);
        nota.setValor(dto.getValor());
//avalia aqui
        Nota salva = notaRepository.save(nota);
        return toResponse(salva);
    }

    public List<MediaAlunoResponse> calcularMediaFiltrada(Long turmaId,
                                                          Long disciplinaId,
                                                          String tipo,
                                                          LocalDate inicio,
                                                          LocalDate fim) {
        List<Aluno> alunos = alunoRepository.findByTurmaId(turmaId);
        return alunos.stream().map(aluno -> {
            List<Nota> notas = notaRepository.buscarComFiltro(
                    aluno.getId(), turmaId, disciplinaId, tipo, inicio, fim
            );
            double somaPesos = notas.stream().mapToDouble(n -> n.getAvaliacao().getPeso()).sum();
            double media = notas.stream()
                    .mapToDouble(n -> n.getValor() * n.getAvaliacao().getPeso())
                    .sum() / (somaPesos == 0 ? 1 : somaPesos);

            return new MediaAlunoResponse(aluno.getId(), aluno.getNome(), media);
        }).collect(Collectors.toList());
    }


    public List<NotaResponse> listarNotasAluno(Long alunoId) {
        List<Nota> notas = notaRepository.findByAlunoId(alunoId);

        return notas.stream().map(nota -> new NotaResponse(
                nota.getId(),
                nota.getValor(),
                new AvaliacaoResponse(
                        nota.getAvaliacao().getId(),
                        nota.getAvaliacao().getTipo(),
                        nota.getAvaliacao().getData(),
                        nota.getAvaliacao().getPeso(),
                        nota.getAvaliacao().getDisciplina().getId(),
                        nota.getAvaliacao().getDisciplina().getNome()
                ),
                new TurmaResponse(
                        nota.getTurma().getId(),
                        nota.getTurma().getNome()
                )
        )).collect(Collectors.toList());


    }

    public List<NotaResponse> salvarLote(List<NotaRequest> dtos) {
        List<Nota> notas = dtos.stream().map(req -> {
            Aluno aluno = alunoRepository.findById(req.getAlunoId())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

            Avaliacao avaliacao = avaliacaoRepository.findById(req.getAvaliacaoId())
                    .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

            Turma turma = turmaRepository.findById(req.getTurmaId())
                    .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

            Nota nota = new Nota();
            nota.setAluno(aluno);
            nota.setAvaliacao(avaliacao);
            nota.setTurma(turma);
            nota.setValor(req.getValor());

            return nota;
        }).collect(Collectors.toList());

        return notaRepository.saveAll(notas)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private NotaResponse toResponse(Nota nota) {
//        NotaResponse notaTeste =  new NotaResponse(
//                nota.getId(),
//                nota.getAluno().getId()
//                nota.getAvaliacao().getId(),
//                nota.getValor(),
//                nota.getTurma().getId()
//        );
        return null;
    }

    public Double calcularMediaPonderada(Long alunoId, Long turmaId) {
        List<Nota> notas = notaRepository.findByAlunoIdAndTurmaId(alunoId, turmaId);

        double somaPesos = 0;
        double somaNotasPonderadas = 0;

        for (Nota nota : notas) {
            double peso = nota.getAvaliacao().getPeso();
            double valor = nota.getValor();

            somaPesos += peso;
            somaNotasPonderadas += valor * peso;
        }

        if (somaPesos == 0) {
            return null;
        }

        return somaNotasPonderadas / somaPesos;
    }

    public List<MediaAlunoResponse> calcularMediaTurmaDisciplina(Long turmaId, Long disciplinaId) {
        List<Aluno> alunos = alunoRepository.findByTurmaId(turmaId);
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByDisciplinaId(disciplinaId);

        return alunos.stream().map(aluno -> {
            double somaPesos = 0;
            double somaNotasPonderadas = 0;

            for (Avaliacao avaliacao : avaliacoes) {
                Optional<Nota> notaOpt = notaRepository.findByAlunoIdAndAvaliacaoId(aluno.getId(), avaliacao.getId());
                if (notaOpt.isPresent()) {
                    double valor = notaOpt.get().getValor();
                    double peso = avaliacao.getPeso();
                    somaPesos += peso;
                    somaNotasPonderadas += valor * peso;
                }
            }

            Double media = (somaPesos > 0) ? somaNotasPonderadas / somaPesos : null;
            return new MediaAlunoResponse(aluno.getId(), aluno.getNome(), media);
        }).collect(Collectors.toList());
    }

}