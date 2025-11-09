package com.boletim.dto;

import java.time.LocalDate;

public class NotaResponse {

    private Long id;
    private double valor;
    private String tipoAvaliacao;
    private LocalDate data;
    private String disciplina;
    private String turma;

    public NotaResponse(Long id, Double valor, String tipoAvaliacao, LocalDate data, String disciplina, String turma) {
    }

    public NotaResponse(Long id, double valor, String tipoAvaliacao, LocalDate data, String disciplina, String turma) {
        this.id = id;
        this.valor = valor;
        this.tipoAvaliacao = tipoAvaliacao;
        this.data = data;
        this.disciplina = disciplina;
        this.turma = turma;
    }

    public NotaResponse(Long id, Long id1, String nome, Long id2, String tipo, Double valor) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(String tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
