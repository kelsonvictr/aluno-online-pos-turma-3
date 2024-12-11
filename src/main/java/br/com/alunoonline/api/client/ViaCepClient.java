package br.com.alunoonline.api.client;


import br.com.alunoonline.api.dtos.EnderecoViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    EnderecoViaCepResponse consultaCep(@PathVariable("cep") String cep);

}
