package br.edu.utfpr.chemistsincontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.chemistsincontrol.model.Equipamento;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.EquipamentoService;

@RestController
@RequestMapping("equipamento")
public class EquipamentoController extends CrudController<Equipamento, Long> {

    @Autowired
    private EquipamentoService equipamentoService;

    @Override
    @Valid
    protected CrudService<Equipamento, Long> getService() {
        return equipamentoService;
    }
}
