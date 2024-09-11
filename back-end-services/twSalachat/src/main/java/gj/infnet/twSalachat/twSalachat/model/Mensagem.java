package gj.infnet.twSalachat.twSalachat.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private Long remetenteId;
    private Long destinatarioId;


    @ManyToOne()
    @JoinColumn(name = "sala_chat_id")
    private SalaChat sala;
}
