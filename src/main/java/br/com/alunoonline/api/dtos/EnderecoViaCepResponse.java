package br.com.alunoonline.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoViaCepResponse {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}


