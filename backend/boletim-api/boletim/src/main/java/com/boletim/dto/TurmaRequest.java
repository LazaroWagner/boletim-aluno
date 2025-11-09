package com.boletim.dto;

import jakarta.validation.constraints.NotBlank;

public class TurmaRequest {

    @NotBlank(message = "O nome da turma é obrigatório")
    private String nome;

    public TurmaRequest() {
    }

    public TurmaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

