package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
    List<MatriculaAluno> findByAlunoId(Long alunoId);

    @Query("SELECT m FROM MatriculaAluno m JOIN m.aluno a WHERE a.name =:nome")
    List<MatriculaAluno> findMatriculasByAlunoNome(@Param("nome") String nome);

    @Query("SELECT m FROM MatriculaAluno m JOIN m.disciplina d WHERE d.name = :nome")
    List<MatriculaAluno> findMatriculasByDisciplinaNome(@Param("nome") String nome);

}
