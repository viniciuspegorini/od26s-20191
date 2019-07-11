package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Formulario;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("formulario")
public class FormularioController extends CrudController<Formulario, Long> {

    @Autowired
    private FormularioService formularioService;

    @Override
    @Valid
    protected CrudService<Formulario, Long> getService() {
        return formularioService;
    }

    @GetMapping("/forms")
    public List<Formulario> getForm() {
        return formularioService.getForm();
    }

    @GetMapping("/find/{id}")
    public List<Formulario> findByNotaId(Long Id) {
        return formularioService.findByNotaId(Id);
    }
}