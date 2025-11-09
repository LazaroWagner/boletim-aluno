package com.boletim.dto;

import jakarta.validation.constraints.NotBlank;

public class DisciplinaRequest {

    @NotBlank(message = "O nome da disciplina é obrigatório")
    private String nome;

    public DisciplinaRequest() {
    }

    public DisciplinaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
