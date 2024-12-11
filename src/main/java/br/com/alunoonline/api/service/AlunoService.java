package br.com.alunoonline.api.service;

import br.com.alunoonline.api.client.ViaCepClient;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;
    private ViaCepClient viaCepClient;

    public void create(Aluno aluno) {
        log.info("Iniciando Criação de aluno");
        atualizaEnderecoPorCep(aluno);

        alunoRepository.save(aluno);
        log.info("Encerrando Criação de aluno");
    }

    public void createAll(List<Aluno> listaAlunos){

        alunoRepository.saveAll(listaAlunos);

    }

    public  void atualizaEnderecoPorCep(Aluno aluno) {

        var cep = aluno.getEndereco().getCep();
        log.info("consultando Cep {} ", cep);
        try {
            var enderecoResponse = viaCepClient.consultaCep(cep);

            aluno.getEndereco().setLocalidade(enderecoResponse.getLocalidade());
            aluno.getEndereco().setUf(enderecoResponse.getUf());
            aluno.getEndereco().setBairro(enderecoResponse.getBairro());
            aluno.getEndereco().setComplemento(enderecoResponse.getComplemento());
            aluno.getEndereco().setLogradouro(enderecoResponse.getLogradouro());
        }catch (Exception e){
            log.warn("Erro de integração, Cep não encontrado {} ", cep);
        }
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorEmaileCpf(String email,
                                         String cpf){
        return alunoRepository.buscarAlunoPorEmaileCpf(email, cpf);
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
    // Faça tratamento para ver se o aluno existe no findbyid
    public void deleteById(Long id) {
        log.info("Iniciando exclusão de alunos");
        alunoRepository.deleteById(id);
        log.info("Encerrando exclusão de alunos");
    }

}
