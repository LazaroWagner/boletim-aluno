package com.boletim.dto;

public class AlunoResponse {

    private Long id;
    private String nome;
    private String turmaNome;

    public AlunoResponse(Long id, String nome, String turmaNome) {
        this.id = id;
        this.nome = nome;
        this.turmaNome = turmaNome;
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

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }
}
