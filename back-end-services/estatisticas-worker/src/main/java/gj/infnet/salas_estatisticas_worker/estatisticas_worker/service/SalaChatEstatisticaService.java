package gj.infnet.salas_estatisticas_worker.estatisticas_worker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.FilmeChatEstatistica;
import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.SalaChat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaChatEstatisticaService {
    private final ObjectMapper objectMapper;
    private final FilmeChatEstatisticaServiceImpl filmeChatEstatisticaService;

    public void processar(String json){
        SalaChat sala= objectMapper.convertValue(json, SalaChat.class);
        filmeChatEstatisticaService.criar(sala);
    }
}
