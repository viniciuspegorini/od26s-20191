package br.edu.utfpr.chemistsincontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.chemistsincontrol.model.Resultado;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.ResultadoService;

@RestController
@RequestMapping("resultado")
public class ResultadoController  extends CrudController<Resultado, Long> {

	@Autowired
	private ResultadoService resultadoService;
	
	@Override
	@Valid
	protected CrudService<Resultado, Long> getService() {
		return resultadoService;
	}
}