package br.twowatch.twowatch.service.impl;

import br.twowatch.twowatch.exceptions.ResourceNotFoundException;
import br.twowatch.twowatch.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceOld {
    private List<Usuario> usuarios = initValues();


    private List<Usuario> initValues() {
        ArrayList<Usuario> usuars = new ArrayList<>();
        usuars.add(new Usuario("Ana", "abc@gmail.com", "123"));
        usuars.add(new Usuario("Rafa", "def@gmail.com", "123"));
        return usuars;
    }


    public List<Usuario> mostrarTodos() {
        return this.usuarios;
    }

    public Usuario atualizar(Usuario atualizacoes) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getId() == atualizacoes.getId()) {
                usuario.setNome(atualizacoes.getNome());
                usuario.setEmail(atualizacoes.getEmail());
                return usuario;
            }
        }
        throw new ResourceNotFoundException("nao foi possivel atualizar, usuario nao encontrado");
    }

    public Usuario encontrarPorId(int id) {
        Optional<Usuario> usuari = this.usuarios.stream().filter((usuario) -> usuario.getId() == id).findFirst();
        if (usuari.isEmpty()) {
            throw new ResourceNotFoundException("Usuario nao encontrado");

        }
        return usuari.get();
    }

    public int removerPorId(int id) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                return usuario.getId();
            }
        }
        throw new ResourceNotFoundException("não foi possivel remover, usuario não encontrado");
    }

    public void cadastrar(Usuario usuario) {
        usuario.setId(usuarios.size() + 1);
        this.usuarios.add(usuario);
    }
}
