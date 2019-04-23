package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@NamedQueries({
        @NamedQuery(name = "Usuario.findByEmailSenha",
                query = "Select u From Usuario u "
                        + "Where u.email=:email AND "
                        + "u.senha=:senha")
})
public class Usuario {

    public static final String findByEmailSenha = "Usuario.findByEmailSenha";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'E-mail'.")
    @Column(length = 100, nullable = false)
    private String email;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Senha'.")
    @Column(length = 100, nullable = false)
    private String senha;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Primeiro Nome'.")
    @Column(length = 50, nullable = false)
    private String primeiroNome;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Segundo Nome'.")
    @Column(length = 50, nullable = false)
    private String segundoNome;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'CPF'.")
    @Column(length = 14, nullable = false)
    private String cpf;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Data de Nascimento'.")
    @Column(nullable = false)
    private LocalDate nascimento;

    @Column(length = 17)
    private String telefone;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Celular'.")
    @Column(length = 17, nullable = false)
    private String celular;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Endereço'.")
    @Column(length = 150, nullable = false)
    private String endereco;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'CEP'.")
    @Column(length = 20, nullable = false)
    private String cep;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Bairro'.")
    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 1, nullable = false)
    private char sexo;
}
