package br.edu.utfpr.chemistsincontrol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.utfpr.chemistsincontrol.model.Formulario;

public interface FormularioRepository  extends IRepository<Formulario>{
	
    List<Formulario> findAllOrderByStatus();

}
