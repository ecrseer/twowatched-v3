package gj.infnet.twSalachat.twSalachat.controller;


import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import gj.infnet.twSalachat.twSalachat.service.SalaChatServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sala-chat")
public class SalaChatController {

    private final SalaChatServiceImpl salaChatService;

    public SalaChatController(SalaChatServiceImpl salaChatService) {
        this.salaChatService = salaChatService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma sala de chat")
    public Long criaSala(@RequestBody SalaChat sala) {
        SalaChat criada = this.salaChatService.save(sala);
        return criada.getId();
    }
}
