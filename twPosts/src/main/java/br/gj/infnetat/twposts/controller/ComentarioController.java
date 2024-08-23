package br.gj.infnetat.twposts.controller;

import br.gj.infnetat.twposts.services.ComentarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioServiceImpl comentarioService;

    @GetMapping("/criar")
    @Operation(summary = "Registra um filme")
    public String criaSala() {
        comentarioService.listar();
        return "uepa";
    }

}