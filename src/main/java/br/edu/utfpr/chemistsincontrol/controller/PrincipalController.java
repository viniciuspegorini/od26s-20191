package br.edu.utfpr.chemistsincontrol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping
public class PrincipalController {

	@GetMapping("user-info")
	public Principal principal(Principal principal) {
		return principal;
	}
}
