package br.edu.utfpr.chemistsincontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.chemistsincontrol.model.Servico;
import br.edu.utfpr.chemistsincontrol.repository.IRepository;
import br.edu.utfpr.chemistsincontrol.repository.ServicoRepository;
import br.edu.utfpr.chemistsincontrol.service.ServicoService;

@Service
public class ServicoServiceImpl extends CrudServiceImpl<Servico> 
implements ServicoService{

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Override
	protected IRepository<Servico> getRepository() {
		return servicoRepository;
	}
}