package br.gj.infnetat.twposts.controller;

import br.gj.infnetat.twposts.model.Comentario;
import br.gj.infnetat.twposts.services.ComentarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioServiceImpl comentarioService;


    @PostMapping("/criar")
    @Operation(summary = "Registra um comentario")
    public Comentario criaComentario(@RequestBody Comentario comentario) {
        return comentarioService.salvar(comentario);
    }



}