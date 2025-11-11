package com.boletim.dto;

import com.boletim.model.Aluno;

public class NotaResponse {

    private Long id;
    private AlunoResponse aluno;
    private double valor;
    private AvaliacaoResponse avaliacao;
    private TurmaResponse turma;


    public NotaResponse(Long id, Double valor, AlunoResponse aluno, AvaliacaoResponse avaliacao, TurmaResponse turma) {
        this.id = id;
        this.valor = valor;
        this.aluno = aluno;
        this.avaliacao = avaliacao;
        this.turma = turma;
    }

//    public NotaResponse(Long id, AlunoResponse aluno, Long avaliacaoId, Double valor, Long turmaId) {
//        this.id = id;
//        this.aluno = new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getTurma());
//        this.valor = valor;
//        this.avaliacao = new AvaliacaoResponse(avaliacaoId, null);
//        this.turma = new TurmaResponse(turmaId, null);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlunoResponse getAluno() {
        return aluno;
    }

    public void setAluno(AlunoResponse aluno) {
        this.aluno = aluno;
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
