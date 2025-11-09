package com.boletim.controller;

import com.boletim.model.Turma;
import com.boletim.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listarToda(){
        List<Turma> turma = turmaService.listarToda();
        return ResponseEntity.ok(turma);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarId(@PathVariable Long id) {
        Optional<Turma> turma = turmaService.buscarId(id);
        return turma.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> criar( @Valid
                                        @RequestBody
                                        Turma turma
                                        ) {
        Turma nova = turmaService.criar(turma);
        URI location = URI.create("/turma/" + nova.getId());
        return ResponseEntity.created(location).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizar(@PathVariable Long id,
                                           @Valid
                                           @RequestBody Turma turmaAtualizada) {
        Optional<Turma> atualizada = turmaService.atualizar(id, turmaAtualizada);
        return atualizada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = turmaService.deletar(id);
        return removida ? ResponseEntity.noContent().build()
                        : ResponseEntity.notFound().build();
    }
}
