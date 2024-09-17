package br.gj.infnetat.twposts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdicionaComentarioDto {
    private String texto;
    private Long usuarioId;
}
