package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Usuario;
import br.edu.utfpr.chemistsincontrol.repository.UsuarioRepository;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends CrudController<Usuario, Long> {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected CrudService<Usuario, Long> getService() {
        return this.usuarioService;
    }


    @Override
    @PostMapping
    public Usuario save(@RequestBody @Valid Usuario entity) {
        if (Optional.ofNullable(entity.getId()).orElse(0L).equals(0L)) {
            entity.setPassword(encoder.encode(entity.getPassword()));
        }
        return super.save(entity);
    }

    @PutMapping("/alterar-senha")
    public Usuario alteraSenha(Usuario usuario) {
        usuario.setPassword(this.encoder.encode(usuario.getPassword()));
        return super.save(usuario);
    }

    @GetMapping( "/orientadores" )
    public List<Usuario> findAllOrientadores(){
        return this.usuarioRepository.findAllByTipoPessoaIgnoreCase("ORIENTADOR");
    }
}
