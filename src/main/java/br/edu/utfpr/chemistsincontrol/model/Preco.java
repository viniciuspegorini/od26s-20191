package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "preco")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Tipo Pessoa'.")
    @Column(length = 45, nullable = false)
    private String tipoPessoa;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Unidade de Medida'.")
    @Column(length = 45, nullable = false)
    private String unMedida;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Valor'.")
    @Column(nullable = false)
    private Float valor;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Equipamento'.")
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Equipamento equipamento;

}
