package br.edu.utfpr.chemistsincontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "amostra")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Amostra extends AbstractModel {

	private static final long serialVersionUID = 1L;

	@Column
    private String descricao;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataRecebimento;

	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Usuario usuario;
}
