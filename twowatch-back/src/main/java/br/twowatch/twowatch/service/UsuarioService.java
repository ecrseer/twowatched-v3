package br.twowatch.twowatch.service;

import br.twowatch.twowatch.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();

    Usuario findById(int id);

    Usuario save(Usuario usuario);

    
}
