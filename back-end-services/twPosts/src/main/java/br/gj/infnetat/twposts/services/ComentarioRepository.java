package br.gj.infnetat.twposts.services;

import br.gj.infnetat.twposts.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
