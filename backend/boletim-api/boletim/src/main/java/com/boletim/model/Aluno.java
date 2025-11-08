package com.boletim.model;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(stratgy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Turma turma;
}
