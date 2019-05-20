package br.edu.utfpr.chemistsincontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Preco {
	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    Long id;

	    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Tipo Pessoa'.")
	    @Column(length = 45, nullable = false)
	    private String tipo_pessoa;
	    
	    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Unidade de Medida'.")
	    @Column(length = 45, nullable = false)
	    private String un_medida;
	    
	    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Valor'.")
	    @Column(nullable = false)
	    private Float valor;
	    
	    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Equipamento'.")
		@ManyToOne
		@JoinColumn(referencedColumnName = "id")
	    private Equipamento equipamento;

}
