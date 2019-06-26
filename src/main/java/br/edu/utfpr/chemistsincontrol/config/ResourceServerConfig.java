package br.edu.utfpr.chemistsincontrol.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                .antMatchers("/amostra/**").hasAnyRole("ADMIN", "RECEPCIONISTA")
                .antMatchers("/equipamento/**").hasAnyRole("ADMIN", "SOLICITANTE")
                .antMatchers("/formulario/**").hasAnyRole("ADMIN", "SOLICITANTE", "RECEPCIONISTA")
                .antMatchers( HttpMethod.GET, "/instituicao/" ).permitAll()
                .antMatchers("/instituicao/**").hasAnyRole("ADMIN", "RECEPCIONISTA")
                .antMatchers("/modelo/**").hasAnyRole("ADMIN", "SOLICITANTE" )
                .antMatchers("/nota/**").hasAnyRole("ADMIN", "RECEPCIONISTA")
                .antMatchers("/preco/**").hasAnyRole("ADMIN")
                .antMatchers("/resultado/**").hasAnyRole("ADMIN", "TECNICO")
                .antMatchers("/login/**").permitAll()
                .antMatchers("/usuario/orientadores").permitAll()
                .antMatchers("/usuario/**").hasAnyRole("ADMIN", "TECNICO", "RECEPCIONISTA", "SOLICITANTE")
                .antMatchers(HttpMethod.POST, "/usuario/").permitAll()

                .anyRequest().authenticated();
    }

}
