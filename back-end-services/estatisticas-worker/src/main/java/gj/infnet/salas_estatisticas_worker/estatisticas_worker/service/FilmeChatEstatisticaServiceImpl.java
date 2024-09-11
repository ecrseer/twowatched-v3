package gj.infnet.salas_estatisticas_worker.estatisticas_worker.service;

import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.FilmeChatEstatistica;
import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.SalaChat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmeChatEstatisticaServiceImpl {

    private final FilmeChatEstatisticaRepository filmeChatEstatisticaRepository;

    public void criar(SalaChat sala) {
        FilmeChatEstatistica estatistica = new FilmeChatEstatistica();
        estatistica.incrementar(sala);
        filmeChatEstatisticaRepository.save(estatistica);
    }
}
