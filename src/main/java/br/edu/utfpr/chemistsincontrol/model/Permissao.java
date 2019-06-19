package br.edu.utfpr.chemistsincontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    public String getAuthority() {
        return this.nome;
    }

}
