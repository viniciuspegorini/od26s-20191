package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Pessoa extends AbstractModel {

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Nome'.")
    @Column(length = 100, nullable = false)
    private String nome;

    @NotNull(message = "Não esqueça de preencher o campo 'CPF'.")
    @Column(length = 14, nullable = false)
    private String cpfCnpj;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'RG'.")
    @Column(length = 100, nullable = false)
    private String rg;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Telefone'.")
    @Column(length = 100, nullable = false)
    private String telefone;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Celular'.")
    @Column(length = 100, nullable = false)
    private String celular;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Departamento'.")
    @Column(length = 100, nullable = false)
    private String departamento;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Status'.")
    @Column(length = 100, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Instituicao instituicao;

    @NotNull(message = "Opa!! Não esqueça de selecionar o campo 'Usuario'.")
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Usuario usuario;

}
