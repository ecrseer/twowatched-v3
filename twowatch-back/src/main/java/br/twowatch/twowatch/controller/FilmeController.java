package br.twowatch.twowatch.controller;

import br.twowatch.twowatch.model.Filme;
import br.twowatch.twowatch.model.SalaChat;
import br.twowatch.twowatch.service.impl.FilmeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private final FilmeServiceImpl filmeService;

    public FilmeController(FilmeServiceImpl filmeService) {
        this.filmeService = filmeService;
    }
    @PostMapping("/criar")
    @Operation(summary = "Registra um filme")
    public Long criaSala(@RequestBody Filme filme) {
        Filme criado = this.filmeService.save(filme);
        return criado.getId();
    }


}
