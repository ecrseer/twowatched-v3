package br.twowatch.twowatch.service.impl;

import br.twowatch.twowatch.model.Usuario;
import br.twowatch.twowatch.service.UsuarioRepository;
import br.twowatch.twowatch.service.UsuarioService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {

        return this.usuarioRepository.findAll();
    }

    public List<Usuario> findAllPaginated(int pagina, int quantidade, boolean ascending) {
        Sort ordem = ascending ? Sort.by("nome").ascending() : Sort.by("nome").descending();
        PageRequest paginacao = PageRequest.of(pagina, quantidade, ordem);
        return this.usuarioRepository.findAll(paginacao).stream().toList();
    }

    @Override
    public Optional<Usuario> findById(int id) {
        return this.usuarioRepository.findById(id);
    }


    public Usuario findByNome(String nome) {
        return this.usuarioRepository.findAllByNome(nome).get();
    }

    @Override
    public Usuario save(Usuario usuario) {
        Usuario salvo = this.usuarioRepository.save(usuario);
        return salvo;
    }


    public Usuario findByEmail(String email) {
        Optional<Usuario> usuario = this.usuarioRepository.findAllByEmail(email);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new RuntimeException("Nao encontrado");
    }


    public Usuario atualiza(int id, Usuario usuario) {
        Optional<Usuario> encontrado = this.findById(id);
        if (encontrado.isEmpty()) {
            throw new RuntimeException("Nao encontrado");
        }
        return this.save(usuario);
    }

}
