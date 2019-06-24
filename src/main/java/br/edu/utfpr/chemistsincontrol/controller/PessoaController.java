package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Pessoa;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("pessoa")
public class PessoaController extends CrudController<Pessoa, Long> {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService service) {
        this.pessoaService = service;
    }

    @Override
    protected CrudService<Pessoa, Long> getService() {
        return pessoaService;
    }

    @RequestMapping("find/{id}")
    public Pessoa findByUsuarioId (@PathVariable Long id){
        Pessoa p = pessoaService.findByUsuarioId(id);
        return p;
    }
}
