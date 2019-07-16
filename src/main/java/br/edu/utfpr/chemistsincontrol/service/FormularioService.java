package br.edu.utfpr.chemistsincontrol.service;

import java.util.List;

import br.edu.utfpr.chemistsincontrol.model.Formulario;

public interface FormularioService extends CrudService<Formulario, Long>{
	
	public List<Formulario> getForm();
	List<Formulario> findByNotaId(Long Id);

}
