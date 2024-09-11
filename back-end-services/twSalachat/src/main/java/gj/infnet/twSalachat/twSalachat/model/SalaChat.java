package gj.infnet.twSalachat.twSalachat.model;

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

    @ElementCollection
    private List<Long> usuariosId;

    @OneToMany()
    @JoinColumn(name = "mensagem_id")
    private List<Mensagem> mensagens;

    private Long filmeId;
    private String filmeNome;

    public SalaChat(String nome) {
        this.nome = nome;
    }

    public SalaChat(String nome, Long filmeId) {
        this.nome = nome;
        this.filmeId = filmeId;
    }

    public SalaChat(String nome, Long filmeId, List<Long> usuariosId) {
        this.nome = nome;
        this.filmeId = filmeId;
        this.usuariosId = usuariosId;
    }

    public boolean isDadosValidos() {
        return this.getUsuariosId() != null && this.getFilmeId() != null;
    }

    public void verificarDados() {
        boolean valido = this.isDadosValidos();
        if (!valido) {
            throw new RuntimeException("Dados invalidos");
        }
    }

}
