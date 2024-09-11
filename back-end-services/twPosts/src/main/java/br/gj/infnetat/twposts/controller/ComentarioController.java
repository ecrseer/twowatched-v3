package br.gj.infnetat.twposts.controller;

import br.gj.infnetat.twposts.model.Comentario;
import br.gj.infnetat.twposts.model.ComentarioDto;
import br.gj.infnetat.twposts.services.ComentarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
@Slf4j
public class ComentarioController {

    private final ComentarioServiceImpl comentarioService;


    @PostMapping("/criar")
    @Operation(summary = "Registra um comentario")
    public Comentario criaComentario(@RequestBody Comentario comentario) {
        return comentarioService.salvar(comentario);
    }

    @GetMapping("/listar")
    public List<ComentarioDto> listarComentarios() {
        log.info("Listando comentarios");
        return this.comentarioService.listar();
    }



}