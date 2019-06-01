package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Usuario;
import br.edu.utfpr.chemistsincontrol.repository.IRepository;
import br.edu.utfpr.chemistsincontrol.repository.UsuarioRepository;
import br.edu.utfpr.chemistsincontrol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario> implements UsuarioService, UserDetailsService {


    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;

    }

    @Override
    public Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha) {
        return getRepository().findByUsuarioAndSenha(usuario, senha);
    }

    @Override
    protected UsuarioRepository getRepository() {
        return this.repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
