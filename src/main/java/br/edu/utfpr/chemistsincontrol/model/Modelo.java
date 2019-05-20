package br.edu.utfpr.chemistsincontrol.model;

/*Glauber*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "modelo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Modelo extends AbstractModel{

    @NotNull(message = "--")
    @Column(length = 50, nullable = false)
    private String nome;

    @Type(type="TEXT")
    @NotNull(message = "--")
    @Column(length = 50, nullable = false)
    private String metodologia;

    @Type(type="TEXT")
    @NotNull(message = "--")
    @Column(length = 50, nullable = false)
    private String resultado;


}
