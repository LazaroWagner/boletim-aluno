package com.boletim.dto;

public class DisciplinaResponse {

    private Long id;
    private String nome;

    public DisciplinaResponse(Long id, String nome) {
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
