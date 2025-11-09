package com.boletim.dto;

public class MediaAlunoResponse {

    private Long alunoId;
    private String alunoNome;
    private Double media;

    public MediaAlunoResponse(Long alunoId, String alunoNome, Double media) {
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.media = media;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public Double getMedia() {
        return media;
    }
}
