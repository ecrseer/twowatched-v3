package gj.infnet.twSalachat.twSalachat.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import gj.infnet.twSalachat.twSalachat.rabbitmq.ApagaSalasVaziasService;
import gj.infnet.twSalachat.twSalachat.rabbitmq.SalaChatEstatisticaService;
import gj.infnet.twSalachat.twSalachat.service.SalaChatServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/sala-chat")
@RequiredArgsConstructor
public class SalaChatController {

    private final SalaChatServiceImpl salaChatService;

    private final ApagaSalasVaziasService apagaSalasVaziasService;
    private final SalaChatEstatisticaService salaChatEstatisticaService;


    @PostMapping("/criar")
    @Operation(summary = "Cria uma sala de chat")
    public Long criaSala(@RequestBody SalaChat sala) throws JsonProcessingException {
        SalaChat criada = this.salaChatService.save(sala);
        Date agora = new Date();
//        this.apagaSalasVaziasService.verificar(agora);
        salaChatEstatisticaService.criarEstatistica(criada);
        return criada.getId();

    }
}
