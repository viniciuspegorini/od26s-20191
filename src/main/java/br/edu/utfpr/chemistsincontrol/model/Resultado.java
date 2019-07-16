package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "resultado")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(referencedColumnName = "id", name = "arquivo_id")
    private Arquivo arquivo;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Usuario'.")
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "usuario_id")
    private Usuario usuario;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Data'.")
    @Column(nullable = false)
    private Date today;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Formulario formulario;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Laudo'.")
    @Type(type = "text")
    @Column
    private String laudo;

}
