package br.twowatch.twowatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    public SalaChat(String nome) {
        this.nome = nome;
    }


}
