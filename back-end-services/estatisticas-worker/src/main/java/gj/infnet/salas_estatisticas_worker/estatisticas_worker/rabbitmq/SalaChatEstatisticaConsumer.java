package gj.infnet.salas_estatisticas_worker.estatisticas_worker.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.SalaChat;
import gj.infnet.salas_estatisticas_worker.estatisticas_worker.service.SalaChatEstatisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor@Component
public class SalaChatEstatisticaConsumer {
    private final SalaChatEstatisticaService salaChatEstatisticaService;

    @RabbitListener(queues = {"sala-chat-estatistica-queue"})
    public void receive(@Payload String json) throws JsonProcessingException {
        salaChatEstatisticaService.processar(json);
    }
}
