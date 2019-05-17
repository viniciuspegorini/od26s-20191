package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.Instituicao;

import java.util.Optional;

public interface InstituicaoRepository extends IRepository<Instituicao> {

    Optional<Instituicao> findByUsuarioAndSenha(String usuario, String senha);

}
