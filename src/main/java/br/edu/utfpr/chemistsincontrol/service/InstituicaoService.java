package br.edu.utfpr.chemistsincontrol.service;

import br.edu.utfpr.chemistsincontrol.model.Instituicao;

import java.util.Optional;

public interface InstituicaoService extends CrudService<Instituicao> {

    Optional<Instituicao> findByUsuarioAndSenha(String usuario, String senha);
}
