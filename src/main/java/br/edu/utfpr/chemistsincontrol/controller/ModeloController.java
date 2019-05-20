package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("modelo")
public class ModeloController extends CrudController<Modelo> {


    private ModeloService modeloService;

    @Autowired
    public ModeloController (ModeloService service) {this.modeloService = service;}

    @Override
    protected CrudService<Modelo> getService() {
        return modeloService;
    }

}
