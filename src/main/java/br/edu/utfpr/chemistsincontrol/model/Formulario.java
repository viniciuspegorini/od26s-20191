package br.edu.utfpr.chemistsincontrol.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "formulario")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data

public class Formulario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Nota nota;


	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Modelo modelo;


	@Column(length = 255)
	private String metodologia;

	@NotNull(message="Não esqueça selecionar a natureza de operação")
	@Column(length = 255)
	private String naturezaOperacao;


	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Departamento'.")
	@Column(length = 45, nullable = false)

	private String departamento;

	@Column
	private Double quantidade_ensaios;

	@Column
	private Double valor_total;
	
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Amostra amostra;

	@NotNull(message = "Status não foi preenchido")
	@Column(length = 45, nullable = false)
	private String status;

}
