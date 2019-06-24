package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Pessoa;
import br.edu.utfpr.chemistsincontrol.repository.PessoaRepository;
import br.edu.utfpr.chemistsincontrol.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl extends CrudServiceImpl<Pessoa, Long>
implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	protected PessoaRepository getRepository() {
		return pessoaRepository;
	}

	@Override
	public Pessoa findByUsuarioId(Long Id){
		return pessoaRepository.findByUsuarioId(Id);
	}

}
