package br.edu.utfpr.chemistsincontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.chemistsincontrol.model.Preco;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.PrecoService;

@RestController
@RequestMapping("preco")
public class PrecoController extends CrudController<Preco, Long> {

	@Autowired
	private PrecoService precoService;
	
	@Override
	@Valid
	protected CrudService<Preco, Long> getService() {
		return precoService;
	}
}