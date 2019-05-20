package br.edu.utfpr.chemistsincontrol.controller;

import br.edu.utfpr.chemistsincontrol.model.Usuario;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import br.edu.utfpr.chemistsincontrol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends CrudController<Usuario> {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.usuarioService = service;
    }

    @Override
    protected CrudService<Usuario> getService() {
        return this.usuarioService;
    }
}
