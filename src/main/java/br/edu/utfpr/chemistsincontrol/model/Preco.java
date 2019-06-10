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
@Table(name = "preco")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Preco extends AbstractModel {
	
	 private static final long serialVersionUID = 1L;

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
