package br.gj.infnetat.twposts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private Long usuarioId;

    @ManyToOne()
    @JoinColumn(name = "pai_id")
    private Comentario pai;

    @ManyToMany()
    private List<Comentario> filhos;

    public Comentario(String texto) {
        this.texto = texto;
    }

    public Comentario(String texto, Long usuarioId, Comentario pai, List<Comentario> filhos) {
        this.texto = texto;
        this.usuarioId = usuarioId;
        this.pai = pai;
        this.filhos = filhos;
    }
}
