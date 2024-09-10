package gj.infnet.twSalachat.twSalachat.rabbitmq;


import com.fasterxml.jackson.core.JsonProcessingException;
import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaChatEstatisticaService {

    private final SalaChatEstatisticaProducer producer;

    public void criarEstatistica(SalaChat salaChat) throws JsonProcessingException {
        producer.send(salaChat);
    }
}
