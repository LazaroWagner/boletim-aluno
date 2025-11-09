package com.boletim.controller;

import com.boletim.dto.AlunoRequest;
import com.boletim.dto.AlunoResponse;
import com.boletim.model.Aluno;
import com.boletim.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.buscarId(id);
        return aluno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<Aluno>> listarTurma(@PathVariable Long turmaId) {
        return  ResponseEntity.ok(alunoService.listarTurma(turmaId));
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> criar( @Valid
                                                @RequestBody AlunoRequest dto
                                                ) {
        Aluno novo = alunoService.criar(dto);
        URI location = URI.create("/aluno/" + novo.getId());
        return ResponseEntity.created(location).body(alunoService.toResponse(novo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable Long id,
                                                   @Valid
                                           @RequestBody AlunoRequest dto) {
        Optional<Aluno> atualizado = alunoService.atualizar(id, dto);
        return atualizado.map(aluno -> ResponseEntity.ok(alunoService.toResponse(aluno)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = alunoService.deletar(id);
        return removido ? ResponseEntity.noContent().build()
                        : ResponseEntity.notFound().build();
    }
}
