package br.gj.infnetat.twfilmes.service;

import br.gj.infnetat.twfilmes.model.Filme;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServiceImpl {

    private final FilmeRepository filmeRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }


    public Filme save(Filme filme) {
        if (filme.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Filme sem titulo ");
        }
        return this.filmeRepository.save(filme);
    }


    public List<Filme> findAllPaged(int page, int pageSize, boolean ascending) {
        var all = this.filmeRepository.findAll();
        Sort ordenacao = Sort.by("title").ascending();
        PageRequest paginacao = PageRequest.of(page, pageSize, ordenacao);
        return this.filmeRepository.findAll(paginacao).stream().toList();
    }

    public List<Filme> findAllPaged(Pageable paginaRequest) {
        PageRequest paginacao = PageRequest.of(paginaRequest.getPageNumber(), paginaRequest.getPageSize(), paginaRequest.getSort());
        var all = this.filmeRepository.findAll();
        Sort ordenacao = Sort.by("title").ascending();
        return this.filmeRepository.findAll(paginacao).stream().toList();
    }
}
