package br.edu.utfpr.chemistsincontrol.security;

import br.edu.utfpr.chemistsincontrol.model.Usuario;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("usuarioLogado")
public class UsuarioLogado implements Serializable {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return usuario != null;
    }

}
