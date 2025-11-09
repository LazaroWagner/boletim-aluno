package com.boletim.dto;

import java.time.LocalDate;

public class AvaliacaoResponse {

    private Long id;
    private String tipo;
    private LocalDate data;
    private Integer peso;
    private Long disciplinaId;
    private String disciplinaNome;

    public AvaliacaoResponse(Long id, String tipo, LocalDate data, Integer peso, Long disciplinaId, String disciplinaNome) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.peso = peso;
        this.disciplinaId = disciplinaId;
        this.disciplinaNome = disciplinaNome;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getPeso() {
        return peso;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public String getDisciplinaNome() {
        return disciplinaNome;
    }
}