package br.gj.infnetat.twposts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("twUsuarios")
public interface UsuarioClient {

    @GetMapping("/usuario/por-id/{id}")
    UsuarioPayload encontraUsuarioPorId(@PathVariable Long id);
}
