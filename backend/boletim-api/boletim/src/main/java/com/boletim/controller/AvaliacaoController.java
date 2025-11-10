package com.boletim.controller;

import com.boletim.dto.AvaliacaoRequest;
import com.boletim.dto.AvaliacaoResponse;
import com.boletim.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponse>> listarTodo() {
        return ResponseEntity.ok(avaliacaoService.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoResponse> buscarId(@PathVariable Long id) {
        Optional<AvaliacaoResponse> avaliacao = avaliacaoService.buscarId(id);
        return avaliacao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/disciplina/{idDisciplina}")
    public List<AvaliacaoResponse> listarDisciplina(@PathVariable Long idDisciplina) {
        return avaliacaoService.listarDisciplina(idDisciplina);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoResponse> criar(@Valid @RequestBody AvaliacaoRequest dto) {
        AvaliacaoResponse nova = avaliacaoService.criar(dto);
        URI location = URI.create("/avaliacao/" + nova.getId());
        return ResponseEntity.created(location).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponse> atualizar(@PathVariable Long id,
                                                       @Valid
                                                       @RequestBody AvaliacaoRequest dto
                                                       ) {
        Optional<AvaliacaoResponse> atualizada = avaliacaoService.atualizar(id, dto);
        return atualizada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = avaliacaoService.deletar(id);
        return removida ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
