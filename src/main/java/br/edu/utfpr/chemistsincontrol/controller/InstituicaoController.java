package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Instituicao;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;

public class InstituicaoController extends CrudController<Instituicao> {

    private InstituicaoService instituicaoService;

    @Autowired
    public InstituicaoController(InstituicaoService service) {
        this.instituicaoService = service;
    }

    @Override
    protected CrudService<Instituicao> getService() {
        return this.instituicaoService;
    }
}
