package com.boletim.dto;

import com.boletim.model.Turma;

public class TurmaResponse {

    private Long id;
    private String nome;

    public TurmaResponse(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
    }

    public TurmaResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

