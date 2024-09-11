package gj.infnet.usuarios.twUsuarios.service;

import gj.infnet.usuarios.twUsuarios.exceptions.ResourceNotFoundException;
import gj.infnet.usuarios.twUsuarios.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public List<Usuario> findAll() {

        return this.usuarioRepository.findAll();
    }

    public List<Usuario> findAllPaginated(int pagina, int quantidade, boolean ascending) {
        Sort ordem = ascending ? Sort.by("nome").ascending() : Sort.by("nome").descending();
        PageRequest paginacao = PageRequest.of(pagina, quantidade, ordem);
        return this.usuarioRepository.findAll(paginacao).stream().toList();
    }


    public Usuario findById(Long id) {
        Optional<Usuario> byId = this.usuarioRepository.findById(id);
        if(byId.isEmpty()){
            throw new ResourceNotFoundException("Usuario n encontrado nesse id");
        }
        return byId.get();
    }


    public Usuario findByNome(String nome) {
        return this.usuarioRepository.findAllByNome(nome).get();
    }


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


    public Usuario atualiza(Long id, Usuario usuario) {
        this.findById(id);

        return this.save(usuario);
    }

    public Usuario deleta(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            this.usuarioRepository.delete(usuario.get());
            return usuario.get();
        }
        throw new ResourceNotFoundException("Usuario n encontrado para remover");
    }
}
