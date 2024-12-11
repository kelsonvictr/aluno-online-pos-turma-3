package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome do professor não pode ser vazio")
    @Size(min = 2, max = 150, message = "O nome do professor " +
            "deve ser entre 2 e 150 caracteres")
    private String name;

    @Email(message = "O e-mail deve conter @ ")
    private String email;

    private String cpf;

    @OneToMany(mappedBy = "professor")
    private Set<Disciplina> disciplinas;

}
