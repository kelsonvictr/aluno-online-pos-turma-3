package br.com.alunoonline.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoResponse {
    private String nomeDoAluno;
    private String emailDoAluno;
    private String cpfDoAluno;
    private List<DisciplinasAlunoResponse> disciplinasAlunoResponseList;
}
