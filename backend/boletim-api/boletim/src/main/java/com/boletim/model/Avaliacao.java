package com.boletim.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O tipo da avaliação é obrigatório")
    private String tipo; // Ex: Prova, Trabalho, Seminário

    @NotNull(message = "O peso da avaliação é obrigatório")
    @Min(value = 1, message = "O peso mínimo é 1")
    @Max(value = 5, message = "O peso máximo é 5")
    private Integer peso;

    @NotNull(message = "A data da avaliação é obrigatória")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> nota;

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

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Nota> getNota() {
        return nota;
    }

    public void setNota(List<Nota> nota) {
        this.nota = nota;
    }
}

