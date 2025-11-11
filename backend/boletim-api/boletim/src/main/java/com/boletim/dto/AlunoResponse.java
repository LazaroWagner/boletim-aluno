package com.boletim.dto;

public class AlunoResponse {

    private Long id;
    private String nome;
    private TurmaResponse turma;

    public AlunoResponse(Long id, String nome, TurmaResponse turma) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TurmaResponse getTurma() {
        return turma;
    }

    public void setTurma(TurmaResponse turma) {
        this.turma = turma;
    }
}
