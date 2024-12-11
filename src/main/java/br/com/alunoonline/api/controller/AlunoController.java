package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.AlunoRelatorioListaDTO;
import br.com.alunoonline.api.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid  @RequestBody Aluno aluno) {
        log.info("Iniciando criação de aluno");
        alunoService.create(aluno);
        log.info("Encerrando criação de aluno");
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll() {

        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @GetMapping("/relatorio/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoRelatorioListaDTO emitirRelatorio(@PathVariable Long id) {
        Aluno aluno = alunoService.findById(id).get();
        AlunoRelatorioListaDTO dto = new AlunoRelatorioListaDTO();
        dto.setName(aluno.getName());
        dto.setEmail(aluno.getEmail());
        return dto;
    }

    @GetMapping("/{email}/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> buscarPorEmaileCpf(@PathVariable String email ,
                                              @PathVariable String cpf) {
        return Optional.of(
                alunoService.buscarAlunoPorEmaileCpf(email, cpf)
        );
    }

    // FAZER O CONTROLLER: PUT
    // A RESPOSTA DEVE SER NO_CONTENT
    // PRECISO DO ID IGUAL PRECISEI NO FINDBYID
    // PRECISO DO ALUNO NO CORPO DA REQUISIÇÃO IGUAL PRECISEI NO CREATE
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Aluno aluno){
        alunoService.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
    }
}
