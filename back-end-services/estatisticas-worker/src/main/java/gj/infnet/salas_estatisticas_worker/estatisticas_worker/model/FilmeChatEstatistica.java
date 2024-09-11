package gj.infnet.salas_estatisticas_worker.estatisticas_worker.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "filme_chat_estatistica")
public class FilmeChatEstatistica {
    @Id
    private String id;

    private String idFilme;
    private String tituloFilme;
    private String quantidadeAssistida;

    private List<Long> usuarios;


    public void incrementar(SalaChat sala){
        this.setIdFilme(sala.getFilmeId());
        this.setTituloFilme(sala.getFilmeNome());
        this.setUsuarios(sala.getUsuariosId());
        this.setQuantidadeAssistida(this.quantidadeAssistida+1);
    }
}
