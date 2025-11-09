package com.boletim.controller;

import com.boletim.dto.MediaAlunoResponse;
import com.boletim.dto.NotaRequest;
import com.boletim.dto.NotaResponse;
import com.boletim.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public ResponseEntity<List<NotaResponse>> listarTodos() {
        return ResponseEntity.ok(notaService.listarTodo());
    }

    @GetMapping("/aluno/{idAluno}")
    public List<NotaResponse> listarNotasPorAluno(@PathVariable Long idAluno) {
        return notaService.listarNotasAluno(idAluno);
    }

    @GetMapping("/media/filtro")
    public List<MediaAlunoResponse> mediaFiltrada(
            @RequestParam Long turmaId,
            @RequestParam Long disciplinaId,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        return notaService.calcularMediaFiltrada(turmaId, disciplinaId, tipo, inicio, fim);
    }

    @PostMapping
    public ResponseEntity<NotaResponse> criar(@Valid @RequestBody NotaRequest request) {
        NotaResponse nota = notaService.criar(request);
        return ResponseEntity.ok(nota);
    }

    @PostMapping("/lote")
    public ResponseEntity<List<NotaResponse>> salvarEmLote(@Valid @RequestBody List<NotaRequest> requests) {
        List<NotaResponse> notas = notaService.salvarLote(requests);
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/media/turma/{idTurma}/disciplina/{idDisciplina}")
    public ResponseEntity<List<MediaAlunoResponse>> calcularMedias(
            @PathVariable Long idTurma,
            @PathVariable Long idDisciplina) {
        List<MediaAlunoResponse> medias = notaService.calcularMediaTurmaDisciplina(idTurma, idDisciplina);
        return ResponseEntity.ok(medias);
    }
}
