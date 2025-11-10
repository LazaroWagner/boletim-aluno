package com.boletim.dto;

import java.time.LocalDate;

public class AvaliacaoResponse {

    private Long id;
    private String tipo;
    private LocalDate data;
    private double peso;
    private DisciplinaResponse disciplina;


    public AvaliacaoResponse(Long id, String tipo, LocalDate data, double peso, DisciplinaResponse disciplina) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.peso = peso;
        this.disciplina = disciplina;
    }

    public AvaliacaoResponse(String tipo, LocalDate data){
        this.tipo = tipo;
        this.data = data;
    };

    public AvaliacaoResponse(Long id, LocalDate data){
        this.id = id;
        this.data = data;
    };

    public AvaliacaoResponse(Long id, String tipo, LocalDate data, double peso, Long id1, String nome) {

        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.peso = peso;
        this.disciplina = new DisciplinaResponse(id1, nome);
    }

    public AvaliacaoResponse(Long id, String tipo, LocalDate data, double peso, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.peso = peso;
        this.disciplina = new DisciplinaResponse(null, nome);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public DisciplinaResponse getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaResponse disciplina) {
        this.disciplina = disciplina;
    }
}