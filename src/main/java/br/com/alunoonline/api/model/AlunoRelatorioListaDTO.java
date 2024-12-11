package br.com.alunoonline.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoRelatorioListaDTO implements Serializable {

    private String name;
    private String email;

}
