package gj.infnet.usuarios.twUsuarios.service;

import gj.infnet.usuarios.twUsuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findAllByNome(String nome);

    Optional<Usuario> findAllByEmail(String email);
}
