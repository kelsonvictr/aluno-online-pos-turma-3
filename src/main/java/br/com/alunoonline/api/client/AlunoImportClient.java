package br.com.alunoonline.api.client;


import br.com.alunoonline.api.dtos.AlunoFakerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fakerimport", url = "http://localhost:9191")
public interface AlunoImportClient {

    @GetMapping("/alunos")
    public List<AlunoFakerResponseDTO> getListaAlunos();
}
