package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void create(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    // UM MÉTODO FINDBYPROFESSORID QUE ACESSA A ASSINATURA QUE
    // FOI FEITA NO REPOSITORY
    // DICA: RETORNA UMA LIST<DISCIPLINA>
    public List<Disciplina> findByProfessorId(Long professorId) {
        return disciplinaRepository.findByProfessorId(professorId);
    }

}
