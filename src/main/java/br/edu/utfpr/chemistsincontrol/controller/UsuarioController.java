package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Permissao;
import br.edu.utfpr.chemistsincontrol.model.SituacaoCadastro;
import br.edu.utfpr.chemistsincontrol.model.Usuario;
import br.edu.utfpr.chemistsincontrol.repository.UsuarioRepository;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @PostMapping("salvar")
    public Usuario save(@RequestBody @Valid Usuario entity, Principal principal) {
        if (Optional.ofNullable(entity.getId()).orElse(0L).equals(0L)) {
            entity.setPassword(encoder.encode(entity.getPassword()));
        }
        Usuario usuario = usuarioRepository.findByEmail(principal.getName()).orElse(new Usuario());
        List<Permissao> pList = usuario.getPermissoes().stream()
                .filter(p -> p.getNome().contains("ROLE_ADMIN"))
                .collect(Collectors.toList());
        if(pList.size() <= 0){
            entity.setSituacaoCadastro(SituacaoCadastro.P);
        }

        return super.save(entity);
    }

    @PutMapping("/alterar-senha")
    public Usuario alteraSenha(Usuario usuario) {
        usuario.setPassword(this.encoder.encode(usuario.getPassword()));
        return super.save(usuario);
    }
}
