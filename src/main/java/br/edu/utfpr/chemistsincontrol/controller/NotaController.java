package br.edu.utfpr.chemistsincontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.chemistsincontrol.model.Nota;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.NotaService;

@RestController
@RequestMapping("nota")
public class NotaController extends CrudController<Nota, Long> {


    private NotaService notaService;

    @Autowired
    public NotaController (NotaService service) {this.notaService = service;}

    @Override
    protected CrudService<Nota, Long> getService() {
        return notaService;
    }

}
