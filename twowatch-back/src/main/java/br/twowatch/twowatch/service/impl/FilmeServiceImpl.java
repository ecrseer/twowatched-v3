package br.twowatch.twowatch.service.impl;

import br.twowatch.twowatch.model.Filme;
import br.twowatch.twowatch.service.FilmeRepository;
import br.twowatch.twowatch.service.FilmeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServiceImpl implements FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public Filme save(Filme filme) {
        if (filme.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Filme sem titulo ");
        }
        return this.filmeRepository.save(filme);
    }

    @Override
    public List<Filme> findAllPaged(int page, int pageSize, boolean ascending) {
        var all = this.filmeRepository.findAll();
        Sort ordenacao = Sort.by("title").ascending();
        PageRequest paginacao = PageRequest.of(page, pageSize, ordenacao);
        return this.filmeRepository.findAll(paginacao).stream().toList();
    }
}
