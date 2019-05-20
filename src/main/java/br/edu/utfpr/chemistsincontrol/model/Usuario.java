package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "email"})
@Data
public class Usuario extends AbstractModel {
    @NotNull( message = "O E-mail é obrigatório!")
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull( message = "a Senha é obrigatória!")
    @Column(nullable = false)
    private String senha;
    @Column
    private String nome;


}
