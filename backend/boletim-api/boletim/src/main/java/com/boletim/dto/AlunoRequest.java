package com.boletim.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class AlunoRequest {

    @NotBlank(message = "O nome do aluno é obrigatorio")
    private String nome;

    @NotNull(message = "O ID da turma é obrigatorio")
    private Long turmaId;

    public AlunoRequest() {
    }

    public AlunoRequest(String nome, Long turmaId) {
        this.nome = nome;
        this.turmaId = turmaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }
}
