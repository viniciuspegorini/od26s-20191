package br.edu.utfpr.chemistsincontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.chemistsincontrol.model.Formulario;
import br.edu.utfpr.chemistsincontrol.repository.FormularioRepository;
import br.edu.utfpr.chemistsincontrol.service.FormularioService;

@Service
public class FormularioServiceImpl extends CrudServiceImpl<Formulario>
implements FormularioService{

	@Autowired
	private FormularioRepository formularioRepository;
	
	@Override
	protected FormularioRepository getRepository() {
		return formularioRepository;
	}

}
