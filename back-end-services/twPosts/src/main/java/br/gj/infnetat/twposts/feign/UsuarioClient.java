package br.gj.infnetat.twposts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("twowatch-monolito")
public interface UsuarioClient {

    @GetMapping("/usuario/{id}")
    UsuarioPayload encontraUsuarioPorId(@PathVariable Long id);
}
