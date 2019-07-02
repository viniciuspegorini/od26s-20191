package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

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

    @Lob
    private byte[] arquivo;

//    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Usuario'.")
//    @Column(length = 45, nullable = false)
    private String usuario;

    @Column
    private String extensao;

    // @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Data'.")
//    @Column(nullable = false)
    private Date dtAlteracao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Formulario formulario;

//    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Laudo'.")
//    @Column(length = 255, nullable = false)
    private String laudo;

}
