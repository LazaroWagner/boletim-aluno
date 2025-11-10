package com.boletim.dto;

public class NotaResponse {

    private Long id;
    private double valor;
    private AvaliacaoResponse avaliacao;
    private TurmaResponse turma;


    public NotaResponse(Long id, double valor, AvaliacaoResponse avaliacao, TurmaResponse turma) {
        this.id = id;
        this.valor = valor;
        this.avaliacao = avaliacao;
        this.turma = turma;
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

    public AvaliacaoResponse getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(AvaliacaoResponse avaliacao) {
        this.avaliacao = avaliacao;
    }

    public TurmaResponse getTurma() {
        return turma;
    }

    public void setTurma(TurmaResponse turma) {
        this.turma = turma;
    }
}
