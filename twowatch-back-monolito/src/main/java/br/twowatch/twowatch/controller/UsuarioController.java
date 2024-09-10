package br.twowatch.twowatch.controller;

import br.twowatch.twowatch.exceptions.HttpMessagePayload;
import br.twowatch.twowatch.exceptions.ResourceNotFoundException;
import br.twowatch.twowatch.model.Usuario;
import br.twowatch.twowatch.service.impl.UsuarioServiceImpl;
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
    private final UsuarioServiceImpl usuarioServiceImpl;

    public UsuarioController( UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualiza um usuário de uma sala")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "500", description = "Problema ao editar usuario",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))})
    })
    public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario) {
        var id = usuario.getId();
        Usuario atualizado = this.usuarioServiceImpl.atualiza(id,usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(atualizado);
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario criado para entrar em salas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "500", description = "Problema ao salvar usuario",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))})
    })
    public int cadastraUsuario(@RequestBody Usuario usuario) {
        usuarioServiceImpl.save(usuario);
        return usuario.getId();
    }


    @DeleteMapping("/deletar")
    @Operation(summary = "Remove um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario removido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "500", description = "Problema ao editar usuario",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))})
    })
    public ResponseEntity removeUsuario(@RequestBody Usuario usuario) {
        try{
        Usuario deletado= this.usuarioServiceImpl.deleta(usuario.getId());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(deletado);
    } catch (ResourceNotFoundException ex) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HttpMessagePayload("Usuario nao encontrado com esse id"));

    }
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}
              ),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))})
    })
    public ResponseEntity encontraUsuarioPorId(@PathVariable int id) {
        try {
            Usuario usuario = this.usuarioServiceImpl.findById(id);
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
