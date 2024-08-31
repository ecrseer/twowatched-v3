package br.gj.infnetat.twposts.feign;

import lombok.Data;

@Data
public class UsuarioPayload {
    private String nome;
    private String email;

}
