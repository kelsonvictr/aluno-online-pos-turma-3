package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class DisciplinaService {

    DisciplinaRepository disciplinaRepository;

    @CacheEvict(value = "lista_disciplinas", allEntries = true)
    public void create(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }


    @Cacheable("lista_disciplinas")
    public List<Disciplina> findByProfessorId(Long professorId) {
        log.info("Listando Disciplinas");
        return disciplinaRepository.findByProfessorId(professorId);
    }

}
