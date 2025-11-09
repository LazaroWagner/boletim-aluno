package com.boletim.controller;

import com.boletim.dto.DisciplinaRequest;
import com.boletim.dto.DisciplinaResponse;
import com.boletim.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponse>> listarTodos() {
        return ResponseEntity.ok(disciplinaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> buscarId(@PathVariable Long id) {
        Optional<DisciplinaResponse> disciplina = disciplinaService.buscarId(id);
        return disciplina.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponse> criar(@Valid @RequestBody DisciplinaRequest dto) {
        DisciplinaResponse nova = disciplinaService.criar(dto);
        URI location = URI.create("/disciplina/" + nova.getId());
        return ResponseEntity.created(location).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> atualizar(@PathVariable Long id,
                                                        @Valid
                                                        @RequestBody DisciplinaRequest dto
                                                        ) {
        Optional<DisciplinaResponse> atualizada = disciplinaService.atualizar(id, dto);
        return atualizada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = disciplinaService.deletar(id);
        return removida ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}