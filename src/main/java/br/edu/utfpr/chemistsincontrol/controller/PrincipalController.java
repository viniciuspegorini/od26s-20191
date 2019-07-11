package br.edu.utfpr.chemistsincontrol.controller;

import java.security.Principal;

import br.edu.utfpr.chemistsincontrol.model.Usuario;
import br.edu.utfpr.chemistsincontrol.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PrincipalController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("user-info")
	public Principal principal(Principal principal) {
		return principal;
	}

	@GetMapping("logged-user")
	public Usuario getUser(Principal principal){
		if(principal != null){
			return usuarioRepository.findByEmail(principal.getName()).orElse(new Usuario());
		}
		else {
			return new Usuario();
		}
	}
}
