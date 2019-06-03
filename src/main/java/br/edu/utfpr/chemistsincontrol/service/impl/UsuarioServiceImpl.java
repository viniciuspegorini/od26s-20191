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

@Service
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario> implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected IRepository<Usuario> getRepository() {
        return usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado!"));
    }

    @Override
    public Iterable<Usuario> save(Iterable iterable) {
        return super.save(iterable);
    }


}
