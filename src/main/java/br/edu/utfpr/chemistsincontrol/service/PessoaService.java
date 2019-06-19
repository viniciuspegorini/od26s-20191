package br.edu.utfpr.chemistsincontrol.service;

import br.edu.utfpr.chemistsincontrol.model.Pessoa;

public interface PessoaService extends CrudService<Pessoa, Long> {


    Pessoa findByUsuarioId(Long Id);

}