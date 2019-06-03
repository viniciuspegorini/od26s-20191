package br.edu.utfpr.chemistsincontrol.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Permissao extends AbstractModel implements GrantedAuthority {

    @Column(nullable = false)
    @Getter
    @Setter
    private String nome;


    @Override
    public String getAuthority() {
        return this.nome;
    }

}
