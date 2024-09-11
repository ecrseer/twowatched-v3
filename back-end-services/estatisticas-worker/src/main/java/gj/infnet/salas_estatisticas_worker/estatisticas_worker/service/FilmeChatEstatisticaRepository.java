package gj.infnet.salas_estatisticas_worker.estatisticas_worker.service;

import gj.infnet.salas_estatisticas_worker.estatisticas_worker.model.FilmeChatEstatistica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmeChatEstatisticaRepository  extends MongoRepository<FilmeChatEstatistica, String> {

}
