package br.gj.infnetat.twfilmes.controller;


import br.gj.infnetat.twfilmes.model.Filme;
import br.gj.infnetat.twfilmes.service.FilmeServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private final FilmeServiceImpl filmeService;

    public FilmeController(FilmeServiceImpl filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/criar")
    public Long criaFilme(@RequestBody Filme filme) {
        Filme criado = this.filmeService.save(filme);
        return criado.getId();
    }

    @GetMapping("/listar")
    public Iterable<Filme> listarFilmes() {
        return this.filmeService.findAllPaged(0,10  ,false);
    }

    @GetMapping("/listar-paginado")
    public Iterable<Filme> listarFilmes(Pageable pageable) {
        return this.filmeService.findAllPaged(pageable);
    }
}
