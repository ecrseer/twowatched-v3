package br.twowatch.twowatch.controller;

import br.twowatch.twowatch.exceptions.HttpMessagePayload;
import br.twowatch.twowatch.exceptions.ResourceNotFoundException;
import br.twowatch.twowatch.model.Usuario;
import br.twowatch.twowatch.service.impl.UsuarioServiceImpl;
import br.twowatch.twowatch.service.impl.UsuarioServiceOld;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioServiceOld usuarioService;
    private final UsuarioServiceImpl usuarioServiceImpl;

    public UsuarioController(UsuarioServiceOld usuarioService, UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioService = usuarioService;
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario) {
        System.out.println("PUT");
        Usuario atualizado = this.usuarioService.atualizar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(atualizado);
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um usuário")
    public int cadastraUsuario(@RequestBody Usuario usuario) {
        usuarioService.cadastrar(usuario);
        return usuario.getId();
    }


    @DeleteMapping
    public int removeUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.removerPorId(usuario.getId());
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))})
    })
    public ResponseEntity encontraUsuarioPorId(@PathVariable int id) {
        try {
            Usuario usuario = this.usuarioService.encontrarPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HttpMessagePayload("Usuario nao encontrado com esse id"));

        }
    }

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return this.usuarioServiceImpl.findAll();
    }

    @GetMapping("por-nome")
    public Usuario encontraUsuarioPorNome(@RequestParam String nome) {
        return this.usuarioServiceImpl.findByNome(nome);
    }

}
