package br.twowatch.twowatch.service;

import br.twowatch.twowatch.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findAllByNome(String nome);

    Optional<Usuario> findAllByEmail(String email);
}
