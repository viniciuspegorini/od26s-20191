package br.edu.utfpr.chemistsincontrol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nota")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Nota extends AbstractModel{
	
	@NotEmpty(message = "Não esqueça de preencher o campo 'Numero'.")
    @Column(length = 100, nullable = false)
    private String numero;
	
	@NotEmpty(message = "Não esqueça de preencher o campo 'Tipo nota'.")
    @Column(length = 100, nullable = false)
    private String tipoNota;
	
    @NotNull(message = "Não esqueça de preencher o campo 'Pessoa'.")
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Pessoa pessoa;
    
    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Valor'.")
    @Column(nullable = false)
    private Double valor;
    
    @NotEmpty(message = "Opa!! Não esqueça de preencher o campo 'Data'.")
    @Column(nullable = false)
    private Date data;
	
}
