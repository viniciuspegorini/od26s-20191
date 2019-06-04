package br.edu.utfpr.chemistsincontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.chemistsincontrol.model.Resultado;
import br.edu.utfpr.chemistsincontrol.repository.IRepository;
import br.edu.utfpr.chemistsincontrol.repository.ResultadoRepository;
import br.edu.utfpr.chemistsincontrol.service.ResultadoService;


@Service
public class ResultadoServiceImpl extends CrudServiceImpl<Resultado>
implements ResultadoService{

	@Autowired
	private ResultadoRepository resultadoRepository;
	
	@Override
	protected IRepository<Resultado> getRepository() {
		return resultadoRepository;
	}
}