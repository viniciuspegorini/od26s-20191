package br.edu.utfpr.chemistsincontrol.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/equipamento/**").hasAnyRole("ADMIN,USER")
			.antMatchers("/pessoa/**").hasAnyRole("ADMIN,USER")
			.antMatchers("/modelo/**").hasAnyRole("ADMIN")
			.antMatchers("/instituicao/**").hasAnyRole("ADMIN,USER")
			.antMatchers("/login/**").permitAll()
			.antMatchers("/usuario/**").permitAll()
			.antMatchers("/user-info/**").permitAll()
			.anyRequest().authenticated();
	}
}
