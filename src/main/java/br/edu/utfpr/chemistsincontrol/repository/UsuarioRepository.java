package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends IRepository<Usuario> {

    Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);

}
