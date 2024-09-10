package gj.infnet.usuarios.twUsuarios;



import gj.infnet.usuarios.twUsuarios.model.Usuario;
import gj.infnet.usuarios.twUsuarios.service.UsuarioServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioServiceTests {
    @Autowired
    UsuarioServiceImpl usuarioService;

    @Test
    @DisplayName("Usuarios sao atualizados")
    public void testaAtualizarUsuario() {
        Usuario atualizado = this.usuarioService.atualiza(1L, new Usuario("n", "mmc", ""));
        assertNotNull(atualizado);
    }

    @Test
    @DisplayName("Usuario sao resgatados")
    public void testaEncontraUsuarioPorEmail() {
        String MOCK_EMAIL = "email@falso.com";
        Usuario salvo = this.usuarioService.save(new Usuario("n", MOCK_EMAIL, ""));
        assertNotNull(salvo);

        Usuario encontrado = this.usuarioService.findByEmail(MOCK_EMAIL);
        assertEquals("n", encontrado.getNome());

    }

    @Test
    @DisplayName("Usuarios sao inseridos")
    public void testaInserirUsuario() {
        List<Usuario> usuarios = this.usuarioService.findAll();
        assertNotNull(usuarios);

        this.usuarioService.save(new Usuario("Gabriel", "gab@gmail.com", "123"));
        List<Usuario> usuariosEinserido = this.usuarioService.findAll();
        assertTrue(usuariosEinserido.size() > usuarios.size());
    }


}
