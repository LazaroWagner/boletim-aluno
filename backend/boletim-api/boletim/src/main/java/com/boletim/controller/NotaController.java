package com.boletim.controller;

import com.boletim.dto.MediaAlunoResponse;
import com.boletim.dto.NotaLoteRequest;
import com.boletim.dto.NotaRequest;
import com.boletim.dto.NotaResponse;
import com.boletim.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/aluno/{id}")
    public ResponseEntity<List<NotaResponse>> listarNotasAluno(@PathVariable Long id) {
        List<NotaResponse> notas = notaService.listarNotasAluno(id);
        return ResponseEntity.ok(notas);
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
        return ResponseEntity.status(HttpStatus.CREATED).body(nota);
    }

    @PostMapping("/lote")
    public ResponseEntity<List<NotaResponse>> salvarNotasLote(@Valid @RequestBody List<NotaLoteRequest> dto) {
        List<NotaResponse> notas = notaService.salvarNotasLote(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(notas);
    }

    @GetMapping("/media/turma/{idTurma}/disciplina/{idDisciplina}")
    public ResponseEntity<List<MediaAlunoResponse>> calcularMedias(
            @PathVariable Long idTurma,
            @PathVariable Long idDisciplina) {
        List<MediaAlunoResponse> medias = notaService.calcularMediaTurmaDisciplina(idTurma, idDisciplina);
        return ResponseEntity.ok(medias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaResponse> atualizar(@PathVariable Long id, @RequestBody NotaRequest dto) {
        NotaResponse atualizada = notaService.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        notaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
