package br.com.alunoonline.api.model;

import br.com.alunoonline.api.validators.EmailValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser em branco")
    @Size(min = 2, max = 150, message = "O nome deve ter entre 2 e 30 caracteres")
    private String name;

     @EmailValidation
    private String email;

    @CPF
    private String cpf;

    private Integer anoNascimento;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    private Endereco endereco;

}
