package gj.infnet.salas_estatisticas_worker.estatisticas_worker.model;

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


    private Long filmeId;


    @ElementCollection
    private List<Long> usuariosId;

    public SalaChat(String nome) {
        this.nome = nome;
    }


}
