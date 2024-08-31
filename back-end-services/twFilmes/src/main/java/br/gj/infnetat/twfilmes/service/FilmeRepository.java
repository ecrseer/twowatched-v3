package br.gj.infnetat.twfilmes.service;

import br.gj.infnetat.twfilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
