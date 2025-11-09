package com.boletim.controller;

import com.boletim.dto.MediaAlunoResponse;
import com.boletim.dto.NotaRequest;
import com.boletim.dto.NotaResponse;
import com.boletim.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/medias")
    public ResponseEntity<List<MediaAlunoResponse>> calcularMedias(
            @RequestParam Long turmaId,
            @RequestParam Long disciplinaId) {
        List<MediaAlunoResponse> medias = notaService.calcularMediaTurmaDisciplina(turmaId, disciplinaId);
        return ResponseEntity.ok(medias);
    }
}
