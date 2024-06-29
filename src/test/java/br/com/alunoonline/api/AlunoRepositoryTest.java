package br.com.alunoonline.api;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    private String EMAIL = "joaoTeste@gmail.com";


    @Test
    @Order(1)
    public void testCreateAluno() {
        Aluno aluno  = new Aluno(null, "João", EMAIL, "00011122233", 1982);
        aluno =  alunoRepository.save(aluno);
        assertThat(aluno.getId()).isNotNull();
    }

    @Test
    @Order(2)
    public void testFindByName() {
        List<Aluno> alunos = alunoRepository.findByName("João");
        assertThat(alunos).isNotEmpty();
    }

    @Test
    @Order(3)
    public void deleteByEmail() {
        List<Aluno> alunos = alunoRepository.findAllByEmail(EMAIL);
        alunoRepository.deleteAll(alunos);
        alunos = alunoRepository.findAllByEmail(EMAIL);
        assertThat(alunos).isEmpty();
    }
}
