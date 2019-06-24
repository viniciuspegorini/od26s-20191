package br.edu.utfpr.chemistsincontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Permissao implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(length = 50, nullable = false)
    @Getter
    @Setter
    private String nome;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.nome;
    }

}
