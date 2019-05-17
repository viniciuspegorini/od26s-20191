package br.edu.utfpr.chemistsincontrol.service;

import br.edu.utfpr.chemistsincontrol.model.Usuario;

import java.util.Optional;

public interface UsuarioService extends CrudService<Usuario> {

    Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
}
