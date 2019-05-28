package br.edu.utfpr.chemistsincontrol.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(of = {"id", "usuario"})
public class Usuario extends AbstractModel implements UserDetails {

    @NotNull(message = "O E-mail é obrigatório!")
    @Column(nullable = false, unique = true)
    private String usuario;

    @NotNull(message = "A Senha é obrigatória!")
    @Column(nullable = false)
    private String senha;

    @Column
    private String nome;

    @OneToMany(orphanRemoval = true)
    @JoinTable(
            name = "usuario_permissoes",
            joinColumns = @JoinColumn(name = "id_permissao"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Permissao> roles;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)

    private Set<Permissao> permissoes;


    public List<Permissao> getRoles() {
        return roles;
    }

    public void setRoles(List<Permissao> roles) {
        this.roles = roles;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auto = new ArrayList<>();
        auto.addAll(getPermissoes());

        return auto;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.usuario;
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
}
