package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Instituicao;
import br.edu.utfpr.chemistsincontrol.repository.InstituicaoRepository;
import br.edu.utfpr.chemistsincontrol.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoServiceImpl extends CrudServiceImpl<Instituicao, Long> implements InstituicaoService {


    private InstituicaoRepository repository;

    @Autowired
    public InstituicaoServiceImpl(InstituicaoRepository repository) {
        this.repository = repository;

    }

    @Override
    protected InstituicaoRepository getRepository() {
        return this.repository;
    }
}
