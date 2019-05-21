package br.edu.utfpr.chemistsincontrol.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(of = {"id", "usuario"})
public class Usuario extends AbstractModel {
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
    private List<Permissoes> roles;

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

    public List<Permissoes> getRoles() {
        return roles;
    }

    public void setRoles(List<Permissoes> roles) {
        this.roles = roles;
    }
}
