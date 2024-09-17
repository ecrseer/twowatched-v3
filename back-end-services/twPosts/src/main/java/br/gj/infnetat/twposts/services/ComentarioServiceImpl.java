package br.gj.infnetat.twposts.services;

import br.gj.infnetat.twposts.feign.UsuarioClient;
import br.gj.infnetat.twposts.feign.UsuarioPayload;
import br.gj.infnetat.twposts.model.Comentario;
import br.gj.infnetat.twposts.model.ComentarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioServiceImpl {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioClient usuarioClient;



    public Comentario salvar(Comentario dto) {
        Comentario comentario =  (Comentario)  dto;
        return comentarioRepository.save(comentario);
    }

    public List<ComentarioDto> listar() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        List<ComentarioDto> comUsuarios = comentarios.stream().map(comentario -> {
            UsuarioPayload encontrado = buscaUsuarioMicroServico(comentario.getUsuarioId());
            ComentarioDto dto = new ComentarioDto(comentario);
            dto.setUsuario(encontrado);
            return dto;
        }).toList();
        return comUsuarios;
    }

    private UsuarioPayload buscaUsuarioMicroServico(Long usuarioId){
        try{
            UsuarioPayload usuarioPayload = usuarioClient.encontraUsuarioPorId(usuarioId);
            return usuarioPayload;
        }catch (Exception exception){
            var dto = new UsuarioPayload();
            dto.setNome("Nao encontrado");
            return dto;
        }

    }

    public Comentario buscarPorId(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        comentarioRepository.deleteById(id);
    }



}
