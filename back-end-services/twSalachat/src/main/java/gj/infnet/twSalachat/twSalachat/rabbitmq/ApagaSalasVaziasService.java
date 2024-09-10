package gj.infnet.twSalachat.twSalachat.rabbitmq;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ApagaSalasVaziasService {
    private final ApagaSalasVaziasProducer producer;


    public void verificar(Date date) throws JsonProcessingException {
        producer.send(date);
    }
}
