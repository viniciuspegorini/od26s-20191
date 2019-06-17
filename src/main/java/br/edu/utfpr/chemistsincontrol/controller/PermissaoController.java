package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Permissao;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("permissao")
public class PermissaoController extends CrudController<Permissao> {

    private PermissaoService instituicaoService;

    @Autowired
    public PermissaoController(PermissaoService service) {
        this.instituicaoService = service;
    }

    @Override
    protected CrudService<Permissao> getService() {
        return this.instituicaoService;
    }
}
