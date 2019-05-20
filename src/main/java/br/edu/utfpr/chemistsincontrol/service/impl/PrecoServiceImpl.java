package br.edu.utfpr.chemistsincontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.chemistsincontrol.model.Preco;
import br.edu.utfpr.chemistsincontrol.repository.PrecoRepository;
import br.edu.utfpr.chemistsincontrol.service.PrecoService;

@Service
public class PrecoServiceImpl extends CrudServiceImpl<Preco, Integer>
implements PrecoService{

	@Autowired
	private PrecoRepository precoRepository;
	
	@Override
	protected JpaRepository<Preco, Integer> getRepository() {
		return precoRepository;
	}
}