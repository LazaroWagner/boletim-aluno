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
    private double peso;

    @NotNull(message = "A data da avaliação é obrigatória")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas;

    public Avaliacao() {
    }

    public Avaliacao(Long id, String tipo, double peso, LocalDate data, Disciplina disciplina, List<Nota> notas) {
        this.id = id;
        this.tipo = tipo;
        this.peso = peso;
        this.data = data;
        this.disciplina = disciplina;
        this.notas = notas;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", data=" + data +
                '}';
    }
}

