package com.boletim.dto;

public class NotaResponse {

    private Long id;
    private Long alunoId;
    private String alunoNome;
    private Long avaliacaoId;
    private String avaliacaoTipo;
    private Double valor;

    public NotaResponse(Long id, Long alunoId, String alunoNome, Long avaliacaoId, String avaliacaoTipo, Double valor) {
        this.id = id;
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.avaliacaoId = avaliacaoId;
        this.avaliacaoTipo = avaliacaoTipo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public Long getAvaliacaoId() {
        return avaliacaoId;
    }

    public String getAvaliacaoTipo() {
        return avaliacaoTipo;
    }

    public Double getValor() {
        return valor;
    }
}
