package br.edu.utfpr.chemistsincontrol.service;

import br.edu.utfpr.chemistsincontrol.model.Pessoa;

public interface PessoaService extends CrudService<Pessoa> {


    Pessoa findByUsuarioId(Long Id);

}