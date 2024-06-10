package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.MatriculaAluno;
import org.hibernate.query.sqm.mutation.internal.inline.MatchingIdRestrictionProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
    List<MatriculaAluno> findByAlunoId(Long alunoId);
}
