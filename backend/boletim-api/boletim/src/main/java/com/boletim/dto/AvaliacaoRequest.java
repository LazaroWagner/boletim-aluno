package com.boletim.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AvaliacaoRequest {

    @NotBlank(message = "O tipo da avaliação é obrigatório")
    private String tipo;

    @NotNull(message = "A data da avaliação é obrigatória")
    private LocalDate data;

    @NotNull(message = "O peso da avaliação é obrigatório")
    @Min(value = 1, message = "O peso mínimo é 1")
    @Max(value = 5, message = "O peso máximo é 5")
    private double peso;


    @NotNull(message = "O ID da disciplina é obrigatório")
    private Long disciplinaId;

    public AvaliacaoRequest() {
    }

    public AvaliacaoRequest(String tipo, LocalDate data,double peso, Long disciplinaId) {
        this.tipo = tipo;
        this.data = data;
        this.peso = peso;
        this.disciplinaId = disciplinaId;
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

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}