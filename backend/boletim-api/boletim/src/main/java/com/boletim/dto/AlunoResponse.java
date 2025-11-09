package com.boletim.dto;

public class AlunoResponse {

    private Long id;
    private String nome;
    private String turma;

    public AlunoResponse(Long id, String nome, String turma) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTurma() {
        return turma;
    }
}
