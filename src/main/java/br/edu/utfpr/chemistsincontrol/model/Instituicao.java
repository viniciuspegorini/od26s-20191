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
public class Instituicao extends  AbstractModel{

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Primeiro Nome'.")
    @Column(length = 150, nullable = false)
    private String razaoSocial;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Segundo Nome'.")
    @Column(length = 50, nullable = false)
    private String nomeFantasia;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'CPF'.")
    @Column(length = 14, nullable = false)
    private String cnpj;

}
