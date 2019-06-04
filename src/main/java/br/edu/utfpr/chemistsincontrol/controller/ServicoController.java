package br.edu.utfpr.chemistsincontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.chemistsincontrol.model.Servico;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.ServicoService;


@RestController
@RequestMapping("servico")
public class ServicoController extends CrudController<Servico> {

	@Autowired
	private ServicoService servicoService;
	
	@Override
	@Valid
	protected CrudService<Servico> getService() {
		return servicoService;
	}
}