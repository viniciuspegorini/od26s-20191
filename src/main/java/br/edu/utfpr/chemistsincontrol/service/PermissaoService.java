package br.edu.utfpr.chemistsincontrol.service;

import br.edu.utfpr.chemistsincontrol.model.Permissao;

public interface PermissaoService extends CrudService<Permissao, Long> {

	Permissao findByNome(String nome);
}
