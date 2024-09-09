package gj.infnet.twSalachat.twSalachat;


import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import gj.infnet.twSalachat.twSalachat.service.SalaChatServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SalaChatServiceTests {

    @Autowired
    private SalaChatServiceImpl salaChatService;



    @Test
    @DisplayName("cadastra sala")
    public void testaCadastraSala() {
        SalaChat salvo = salaChatService.save(new SalaChat("Sala um"));
        assertNotNull(salvo);

        Long filme = 1L;
        SalaChat salaComFilme = new SalaChat(2L, "Sala Com filme", filme, null);
        SalaChat salvoComFilme = salaChatService.save(salaComFilme);
        assertNotNull(salvoComFilme);

        Long usuarioSalvo = 1L;

        SalaChat salaComFilmeEUsuario = new SalaChat(3L, "Sala Com filme e usuario", filme, List.of(usuarioSalvo));
        SalaChat salvoComFilmeUsuario = salaChatService.save(salaComFilmeEUsuario);
        assertNotNull(salvoComFilmeUsuario);
    }
}
