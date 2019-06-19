package br.edu.utfpr.chemistsincontrol.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Usuario extends AbstractModel implements UserDetails {
    private static final long serialVersionUID = 1L;
    private static final BCryptPasswordEncoder bCrypt =
            new BCryptPasswordEncoder(10);

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 512, nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Permissao> permissoes;


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auto = new ArrayList<>();
        auto.addAll(getPermissoes());

        return auto;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void addPermissao(Permissao permissao) {
        if (permissoes == null) {
            permissoes = new HashSet<>();
        }
        permissoes.add(permissao);
    }

    public String getEncodedPassword(String pass) {
        if (pass != null && !pass.equals("")) {
            return bCrypt.encode(pass);
        }
        return pass;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
