package com.boletim.repository;

import com.boletim.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByAlunoIdAndTurmaId(Long alunoId, Long turmaId);

    Optional<Nota> findByAlunoIdAndAvaliacaoId(Long alunoId, Long avaliacaoId);

    List<Nota> findByTurmaId(Long turmaId);

    List<Nota> findByAvaliacaoId(Long avaliacaoId);

    List<Nota> findByAlunoId(Long alunoId);
}
