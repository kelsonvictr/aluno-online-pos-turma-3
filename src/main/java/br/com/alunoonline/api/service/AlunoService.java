package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void create(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public void update(Long id, Aluno aluno) {
        // PRIMEIRO PASSO: PROCURAR SE O ALUNO EXISTE
        Optional<Aluno> alunoFromDb = findById(id);

        // LANÇA UMA EXCEPTION SE NÃO ENCONTRAR O ALUNO NO BD.
        if (alunoFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados");
        }

        // SE CHEGAR AQUI, SIGNIFICA QUE EXISTE ALUNO, ENTÃO
        // VOU ARMAZENA-LO EM UMA VARIÁVEL :)
        Aluno alunoUpdated = alunoFromDb.get();

        // PEGO ESSE alunoUpdated DE CIMA E FAÇO
        // OS SETS NECESSÁRIOS PARA ATUALIZAR OS
        // ATRIBUTOS DELE.
        // alunoUpdated: Aluno que está na memória RAM para ser atualizado
        // aluno: é o objeto java que anteriormente era uma JSON vindo do front.
        alunoUpdated.setName(aluno.getName());
        alunoUpdated.setCpf(aluno.getCpf());
        alunoUpdated.setEmail(aluno.getEmail());

        // PEGUEI A CÓPIA DO ALUNO ALTERADO NA MEMÓRIA RAM E DEVOLVI
        // ESSE ALUNO, AGORA, ATUALIZADO, PARA O BANCO DE DADOS.
        alunoRepository.save(alunoUpdated);

    }

    // FAZER O DELETEBYID, ONDE O PARMETRO É SÓ O ID MESMO...
    // VOID
    // NÃO COLOQUEI O NOME DELETEBYID ATOA
    // SERÁ QUE O REPOSITORY GOSTA DESSE NOME TBM?  #)

}
