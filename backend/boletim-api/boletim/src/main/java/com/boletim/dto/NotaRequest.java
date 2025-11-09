package com.boletim.dto;

import jakarta.validation.constraints.*;

public class NotaRequest {

    @NotNull(message = "O ID do aluno é obrigatório")
    private Long alunoId;

    @NotNull(message = "O ID da avaliação é obrigatório")
    private Long avaliacaoId;

    @NotNull(message = "O ID da turma é obrigatório")
    private Long turmaId;

    @NotNull(message = "O valor da nota é obrigatório")
    @DecimalMin(value = "0.0", message = "A nota mínima é 0")
    @DecimalMax(value = "10.0", message = "A nota máxima é 10")
    private Double valor;

    public NotaRequest() {
    }

    public NotaRequest(Long alunoId, Long avaliacaoId, Long turmaId, Double valor) {
        this.alunoId = alunoId;
        this.avaliacaoId = avaliacaoId;
        this.turmaId = turmaId;
        this.valor = valor;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public Long getAvaliacaoId() {
        return avaliacaoId;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public Double getValor() {
        return valor;
    }
}
