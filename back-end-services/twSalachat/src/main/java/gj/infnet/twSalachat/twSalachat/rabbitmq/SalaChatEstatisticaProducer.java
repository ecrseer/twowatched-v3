package gj.infnet.twSalachat.twSalachat.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class SalaChatEstatisticaProducer {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public void send(SalaChat sala) throws JsonProcessingException {

        amqpTemplate.convertAndSend("sala-chat-estatistica-exc",
                "sala-chat-estatistica-rk", objectMapper.writeValueAsString(sala));
    }
}
