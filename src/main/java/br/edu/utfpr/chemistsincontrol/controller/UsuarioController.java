package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Usuario;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends CrudController<Usuario> {

    private UsuarioService usuarioService;
    private PasswordEncoder encoder;

    @Override
    protected CrudService<Usuario> getService() {
        return this.usuarioService;
    }


    @Override
    @PostMapping
    public Usuario save(@RequestBody @Valid Usuario entity) {
        if (entity.getId().equals(0L)) {
            entity.setPassword(encoder.encode(entity.getPassword()));
        }
        return super.save(entity);
    }

    @PutMapping("/alterar-senha")
    public Usuario alteraSenha(Usuario usuario) {
        usuario.setPassword(this.encoder.encode(usuario.getPassword()));
        return super.save(usuario);
    }
}
