package br.gj.infnetat.twposts.model;

import br.gj.infnetat.twposts.feign.UsuarioPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDto {

    private Long id;
    private String texto;
    private UsuarioPayload usuario;

    public ComentarioDto(Comentario comentario) {
        this.id = comentario.getId();
        this.texto = comentario.getTexto();
    }

}
