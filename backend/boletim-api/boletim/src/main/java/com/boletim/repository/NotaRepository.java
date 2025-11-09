package com.boletim.repository;

import com.boletim.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByAlunoIdAndTurmaId(Long alunoId, Long turmaId);

    Optional<Nota> findByAlunoIdAndAvaliacaoId(Long alunoId, Long avaliacaoId);

    List<Nota> findByTurmaId(Long turmaId);

    List<Nota> findByAvaliacaoId(Long avaliacaoId);

    List<Nota> findByAlunoId(Long alunoId);


//    List<Nota> findByAlunoIdAndTurmaIdAndAvaliacao_Disciplina_Id(Long id, Long turmaId, Long disciplinaId, String tipo, LocalDate inicio, LocalDate fim);
    @Query("SELECT n FROM Nota n WHERE " +
            "n.aluno.id = :alunoId AND " +
            "n.turma.id = :turmaId AND " +
            "n.avaliacao.disciplina.id = :disciplinaId AND " +
            "(:tipo IS NULL OR n.avaliacao.tipo = :tipo) AND " +
            "(:inicio IS NULL OR n.avaliacao.data >= :inicio) AND " +
            "(:fim IS NULL OR n.avaliacao.data <= :fim)")
    List<Nota> buscarComFiltro(
            @Param("alunoId") Long alunoId,
            @Param("turmaId") Long turmaId,
            @Param("disciplinaId") Long disciplinaId,
            @Param("tipo") String tipo,
            @Param("inicio") LocalDate inicio,
            @Param("fim") LocalDate fim
    );


}
