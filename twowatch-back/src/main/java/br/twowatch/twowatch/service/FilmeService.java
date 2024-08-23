package br.twowatch.twowatch.service;

import br.twowatch.twowatch.model.Filme;

import java.util.List;

public interface FilmeService {
    Filme save(Filme filme);

    List<Filme> findAllPaged(int page, int pageSize, boolean ascending);
}
