package gj.infnet.salas_estatisticas_worker.estatisticas_worker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaChat {
    private Long id;
    private String nome;


    private List<Long> usuariosId;


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


}
