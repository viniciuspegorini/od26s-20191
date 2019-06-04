package br.edu.utfpr.chemistsincontrol.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PrincipalController {

	@GetMapping("user-info")
	public Principal principal(Principal principal) {
		return principal;
	}
}
