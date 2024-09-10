package gj.infnet.twSalachat.twSalachat.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ApagaSalasVaziasProducer {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public void send(Date date) throws JsonProcessingException {

        amqpTemplate.convertAndSend("apaga-salas-vazias-exc",
                "apaga-salas-vazias-rk",
                objectMapper.writeValueAsString(date));
    }
}
