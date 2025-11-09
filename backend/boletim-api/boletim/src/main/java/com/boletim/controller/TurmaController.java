package com.boletim.controller;

import com.boletim.dto.TurmaRequest;
import com.boletim.dto.TurmaResponse;
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
    public ResponseEntity<List<TurmaResponse>> listarToda(){
        return ResponseEntity.ok(turmaService.listarToda());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> buscarId(@PathVariable Long id) {
        Optional<TurmaResponse> turma = turmaService.buscarId(id);
        return turma.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TurmaResponse> criar( @Valid
                                        @RequestBody
                                        TurmaRequest dto
                                        ) {
        TurmaResponse nova = turmaService.criar(dto);
        URI location = URI.create("/turma/" + nova.getId());
        return ResponseEntity.created(location).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponse> atualizar(@PathVariable Long id,
                                           @Valid
                                           @RequestBody TurmaRequest dto) {
        Optional<TurmaResponse> atualizada = turmaService.atualizar(id, dto);
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
