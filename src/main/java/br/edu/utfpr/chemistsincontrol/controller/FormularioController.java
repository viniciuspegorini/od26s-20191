package br.edu.utfpr.chemistsincontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.chemistsincontrol.model.Formulario;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.FormularioService;

@RestController
@RequestMapping("formulario")
public class FormularioController extends CrudController<Formulario> {

    @Autowired
    private FormularioService formularioService;

    @Override
    @Valid
    protected CrudService<Formulario> getService() {
        return formularioService;
    }
    
    @GetMapping("/forms")
    public List<Formulario> getForm(){
        return formularioService.getForm();
    }
    
}