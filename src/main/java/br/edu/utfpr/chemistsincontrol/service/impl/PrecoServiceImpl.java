package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.chemistsincontrol.model.Preco;
import br.edu.utfpr.chemistsincontrol.repository.PrecoRepository;
import br.edu.utfpr.chemistsincontrol.service.PrecoService;

@Service
public class PrecoServiceImpl extends CrudServiceImpl<Preco>
implements PrecoService{

	@Autowired
	private PrecoRepository precoRepository;
	
	@Override
	protected IRepository<Preco> getRepository() {
		return precoRepository;
	}
}