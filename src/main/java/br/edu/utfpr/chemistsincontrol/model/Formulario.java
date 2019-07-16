package br.edu.utfpr.chemistsincontrol.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

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
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Nota nota;


	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Modelo modelo;

	@Type(type = "text")
	@Column
	private String metodologia;

	@NotEmpty(message="Não esqueça selecionar a natureza de operação")
	@Column(length = 255)
	private String naturezaOperacao;

	@Column
	private Double quantidadeEnsaios;

	@Column
	private Double valorTotal;
	
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Amostra amostra;

	@NotEmpty(message = "Status não foi preenchido")
	@Column(length = 45, nullable = false)
	private String status;

}
