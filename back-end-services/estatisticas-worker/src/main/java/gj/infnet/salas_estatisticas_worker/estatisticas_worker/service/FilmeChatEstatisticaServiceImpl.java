package gj.infnet.salas_estatisticas_worker.estatisticas_worker.service;

import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.FilmeChatEstatistica;
import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.SalaChat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmeChatEstatisticaServiceImpl {

    private final FilmeChatEstatisticaRepository filmeChatEstatisticaRepository;

    public FilmeChatEstatistica criar(SalaChat sala) {
        FilmeChatEstatistica estatistica = new FilmeChatEstatistica();

        estatistica.incrementar(sala);
        log.info(" ---- Salvando incrementando Filme chat Estatistica: {}", estatistica);
        return filmeChatEstatisticaRepository.save(estatistica);
    }
}
