package br.twowatch.twowatch;

import br.twowatch.twowatch.model.Filme;
import br.twowatch.twowatch.service.impl.FilmeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


@SpringBootTest
public class FilmeServiceTests {

    @Autowired
    private FilmeServiceImpl filmeService;

    @Test
    @DisplayName("insere  filme")
    public void testaInserirFilme() {
        List<Filme> inseridosAnteriomente = this.filmeService.findAllPaged(0, 55, true);

        Filme inserido = this.filmeService.save(new Filme("Shrek", ""));
        List<Filme> todosFilmes = this.filmeService.findAllPaged(0, 55, true);

        assertTrue(todosFilmes.size() > inseridosAnteriomente.size());
    }

    @Test
    @DisplayName("consulta todos filmes")
    public void testaConsultaTodosFilmes() {
        List<Filme> filmes = this.filmeService.findAllPaged(0, 5, true);
        assertTrue(filmes.size() > 1);

    }
}
