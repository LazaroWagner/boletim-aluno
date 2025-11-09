package com.boletim.repository;

import com.boletim.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByDisciplinaId(Long disciplinaId);
}
