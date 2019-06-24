package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.Pessoa;

public interface PessoaRepository extends IRepository<Pessoa> {

    Pessoa findByUsuarioId(Long Id);
}
