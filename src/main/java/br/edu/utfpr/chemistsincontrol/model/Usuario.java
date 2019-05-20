package br.edu.utfpr.chemistsincontrol.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "usuario"})
public class Usuario extends AbstractModel {
    @NotNull( message = "O E-mail é obrigatório!")
    @Column(nullable = false, unique = true)
    private String usuario;
    @NotNull( message = "a Senha é obrigatória!")
    @Column(nullable = false)
    private String senha;
    @Column
    private String nome;

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
}
