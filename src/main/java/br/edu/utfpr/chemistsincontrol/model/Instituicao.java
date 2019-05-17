package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "instituicao")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
/*@NamedQueries({
        @NamedQuery(name = "instituicao.findByEmailSenha",
                query = "Select u From instituicao u "
                        + "Where u.email=:email AND "
                        + "u.senha=:senha")
})*/
public class Instituicao extends  AbstractModel{

    //public static final String findByEmailSenha = "instituicao.findByEmailSenha";

    @NotNull(message = "campo Razão Social é Obrigatório'.")
    @Column(length = 150, nullable = false)
    private String razaoSocial;

    @NotNull(message = "campo Nome Fantasia é Obrigatório.")
    @Column(length = 150, nullable = false)
    private String nomeFantasia;

    @NotNull(message = "Campo CNPJ É de preenchimento Obrigatório'.")
    @Column(length = 14, nullable = false)
    private String cnpj;

}
