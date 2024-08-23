package br.gj.infnetat.twposts.services;

import br.gj.infnetat.twposts.feign.UsuarioClient;
import br.gj.infnetat.twposts.feign.UsuarioPayload;
import br.gj.infnetat.twposts.model.Comentario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioServiceImpl {

    private final UsuarioClient usuarioClient;
    private final ComentarioRepository comentarioRepository;



    public Comentario salvar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listar() {
        UsuarioPayload usuarioPayload = usuarioClient.encontraUsuarioPorId(0L);
        System.out.println(usuarioPayload.getNome());
        return comentarioRepository.findAll();
    }

    public Comentario buscarPorId(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        comentarioRepository.deleteById(id);
    }



}
