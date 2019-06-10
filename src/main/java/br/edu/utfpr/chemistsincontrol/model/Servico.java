package br.edu.utfpr.chemistsincontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servico")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Servico extends AbstractModel{
	
	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Nome'.")
    @Column(length = 45, nullable = false)
	private String nome;
	
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Modelo modelo;
	
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Preco preco;

}
