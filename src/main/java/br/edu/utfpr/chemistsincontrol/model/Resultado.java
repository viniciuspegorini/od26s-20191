package br.edu.utfpr.chemistsincontrol.model;

import java.util.Date;

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
@Table(name = "resultado")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Resultado extends AbstractModel {

	@Column(nullable = false)
	private byte[] arquivo;

	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Usuario'.")
	@Column(length = 45, nullable = false)
	private String usuario;

	// @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Data'.")
	@Column(nullable = false)
	private Date dtAlteracao;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Formulario formulario;

	@NotNull(message = "Opa!! Não esqueça de preencher o campo 'Laudo'.")
	@Column(length = 255, nullable = false)
	private String laudo;

}
