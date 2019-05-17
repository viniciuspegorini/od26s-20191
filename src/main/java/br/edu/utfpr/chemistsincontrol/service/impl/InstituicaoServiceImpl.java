package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Instituicao;
import br.edu.utfpr.chemistsincontrol.repository.InstituicaoRepository;
import br.edu.utfpr.chemistsincontrol.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class InstituicaoServiceImpl extends CrudServiceImpl<Instituicao> implements InstituicaoService {


    private InstituicaoRepository repository;

    @Autowired
    public InstituicaoServiceImpl(InstituicaoRepository repository) {
        this.repository = repository;

    }

    @Override
    public Optional<Instituicao> findByUsuarioAndSenha(String usuario, String senha) {
        return getRepository().findByUsuarioAndSenha(usuario, senha);
    }

    @Override
    protected InstituicaoRepository getRepository() {
        return this.repository;
    }
}
