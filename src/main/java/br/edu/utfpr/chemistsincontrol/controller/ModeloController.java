package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;




public class ModeloController extends CrudController<Modelo> {


    private ModeloService modeloService;

    @Autowired
    public ModeloController (ModeloService service) {this.modeloService = service;}

    @Override
    protected CrudService<Modelo> getService() {
        return modeloService;
    }

}
