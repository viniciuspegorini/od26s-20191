package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Permissao;
import br.edu.utfpr.chemistsincontrol.repository.PermissaoRepository;
import br.edu.utfpr.chemistsincontrol.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoServiceImpl extends CrudServiceImpl<Permissao, Long> implements PermissaoService {


    private PermissaoRepository repository;

    @Autowired
    public PermissaoServiceImpl(PermissaoRepository repository) {
        this.repository = repository;

    }

    @Override
    protected PermissaoRepository getRepository() {
        return this.repository;
    }

	@Override
	public Permissao findByNome(String nome) {
		return repository.findByNome(nome);
	}
}
