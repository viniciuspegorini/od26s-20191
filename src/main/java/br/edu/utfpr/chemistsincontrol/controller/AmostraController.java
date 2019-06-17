package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Amostra;
import br.edu.utfpr.chemistsincontrol.service.AmostraService;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("amostra")
public class AmostraController extends CrudController<Amostra> {

    @Autowired
    private AmostraService service;

    @Override
    protected CrudService<Amostra> getService() {
        return this.service;
    }
}
