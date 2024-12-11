package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import br.com.alunoonline.api.service.AlunoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {

    @MockBean
    private AlunoService alunoService;

    @MockBean
    private AlunoRepository alunoRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenPostRequestToAlunosAndInvalidAluno_thenCorrectResponse() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setId(null);
        aluno.setName("");
        aluno.setEmail("notanemail");

        mockMvc.perform(post("/aluno")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(aluno)))
                .andExpect(status().isBadRequest());
    }
}