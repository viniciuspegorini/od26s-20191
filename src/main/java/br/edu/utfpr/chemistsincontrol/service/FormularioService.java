package br.edu.utfpr.chemistsincontrol.service;

import java.util.List;

import br.edu.utfpr.chemistsincontrol.model.Formulario;

public interface FormularioService extends CrudService<Formulario>{
	
	public List<Formulario> getForm();

}
