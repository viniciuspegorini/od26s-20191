package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Usuario;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends CrudController<Usuario> {

    private UsuarioService usuarioService;
    private PasswordEncoder encoder;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.usuarioService = service;
    }

    @Override
    protected CrudService<Usuario> getService() {
        return this.usuarioService;
    }


    @Override
    @PostMapping
    public Usuario save(@Valid Usuario entity) {
        if (entity.getId().equals(0L)) {
            entity.setSenha(encoder.encode(entity.getSenha()));
        }
        return super.save(entity);
    }
}
