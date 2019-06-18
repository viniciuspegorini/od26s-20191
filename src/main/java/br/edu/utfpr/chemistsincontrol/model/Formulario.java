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
	
	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Metodologia Amostra'.")
    @Column(length = 45, nullable = false)
	private String status;
	
	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Metodologia Amostra'.")
    @Column(length = 255, nullable = false)
	private String metodologiaAmostra;
	
	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Metodologia Analitica'.")
    @Column(length = 255, nullable = false)
	private String metodologiaAnalitica;
	
	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Departamento'.")
    @Column(length = 45, nullable = false)
	private String departamento;
	
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Amostra amostra;
		
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Modelo modelo;
		
	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Quantidade de ensaiso'.")
    @Column(nullable = false)
	private Float quantidadeEnsaios;
	
	@Column
	private Float valor;
	
	@Transient
	private Float valorTotal;
	//calcular em execução considerando valor e tipo de pessoa

}
