package gj.infnet.twSalachat.twSalachat.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import gj.infnet.twSalachat.twSalachat.model.Mensagem;
import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import gj.infnet.twSalachat.twSalachat.rabbitmq.SalaChatEstatisticaService;
import gj.infnet.twSalachat.twSalachat.service.SalaChatServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/sala-chat")
@RequiredArgsConstructor
@Slf4j
public class SalaChatController {


    private final SalaChatServiceImpl salaChatService;

    private final SalaChatEstatisticaService salaChatEstatisticaService;


    @PostMapping
    @Operation(summary = "Cria uma sala de chat")
    public String criaSala(@RequestBody SalaChat sala) throws JsonProcessingException {
        log.info("Criando uma sala de chat chamada{}", sala.getNome());
        SalaChat criada = this.salaChatService.save(sala);
        Date agora = new Date();
        salaChatEstatisticaService.criarEstatistica(criada);
        return "Sala criada com id " + criada.getId();

    }

    @GetMapping("/por-id/{id}")
    @Operation(summary = "Busca uma sala por id")
    public SalaChat buscaPorId(@PathVariable Long id) {
        log.info("buscando uma sala de chat chamada");
        SalaChat sala = this.salaChatService.findById(id);
        return sala;
    }

    @PostMapping("/{id}/adiciona-message")
    @Operation(summary = "Adiciona uma mensagem em uma sala de chat")
    public SalaChat criaSala(@PathVariable Long id, @RequestBody Mensagem msg) throws JsonProcessingException {
        log.info("Adicionando mensagem {}", msg);
        return this.salaChatService.adicionaMensagem(id, msg);
    }
}
