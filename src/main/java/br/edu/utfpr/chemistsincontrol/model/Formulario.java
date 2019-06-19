package br.edu.utfpr.chemistsincontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
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
public class Formulario extends AbstractModel{

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Nota nota;

	@NotNull
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Modelo modelo;

//	@NotEmpty(message="Não esqueça de preencher a metodologia")
	@Column(length = 255)
	private String metodologia;

	@NotNull(message="Não esqueça selecionar a natureza de operação")
	@Column(length = 255)
	private String naturezaOperacao;

	@Column(length = 45)
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
