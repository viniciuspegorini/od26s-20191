package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Instituicao;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("instituicao")
public class InstituicaoController extends CrudController<Instituicao, Long> {

    private InstituicaoService instituicaoService;

    @Autowired
    public InstituicaoController(InstituicaoService service) {
        this.instituicaoService = service;
    }

    @Override
    protected CrudService<Instituicao, Long> getService() {
        return this.instituicaoService;
    }
}
