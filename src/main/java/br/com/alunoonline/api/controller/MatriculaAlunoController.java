package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponse;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MatriculaAluno matriculaAluno) {
        matriculaAlunoService.create(matriculaAluno);
    }

    // QUERO UM PATCHMAPPING("/ATUALIZAR-NOTAS/{matriculaAlunoId}}
    // QUERO QUE O RETORNO SEJA UM NO_CONTENT
    // NOME DO MÉTODO: ATUALIZARNOTAS
    // PARAMATROS: REQUESTBODY PARA O DTO E LONG MATRICULAALUNOID
    // NO CORPO DO MÉTODO, CHAME O SERVICE QUE VC ACABOU DE FAZER
    // NO INSOMINIA: FAZER UM REQUEST DO TIPO PATCH PARA A URL
    // MANDAR UM JSON DE ACORDO APENAS COM O DTO

    @PatchMapping("/atualizar-notas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarNotas(@PathVariable Long id, @RequestBody AtualizarNotasRequest atualizarNotasRequest) {
        matriculaAlunoService.atualizarNotas(id, atualizarNotasRequest);
    }

    @PatchMapping("/trancar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarStatusParaTrancado(@PathVariable Long id) {
        matriculaAlunoService.atualizarStatusParaTrancado(id);
    }

    @GetMapping("/emitir-historico/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoResponse emitirHistoricoDoAluno(@PathVariable Long alunoId) {
        return matriculaAlunoService.emitirHistoricoDoAluno(alunoId);
    }



}
