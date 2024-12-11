package br.com.alunoonline.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoFakerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private Integer anoNascimento;
    private String cep;
    private String numeroCasa;
}
