package br.edu.utfpr.chemistsincontrol.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Permissao extends AbstractModel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;


    @Column(length = 50, nullable = false)
    @Getter @Setter
    private String nome;

    @Override
    public String getAuthority() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
