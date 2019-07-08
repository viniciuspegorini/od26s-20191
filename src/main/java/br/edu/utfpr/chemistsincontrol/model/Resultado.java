package br.edu.utfpr.chemistsincontrol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile arquivo;

//    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Usuario'.")
//    @Column(length = 45, nullable = false)
    private Usuario usuario;

     // @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Data'.")
//    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dtAlteracao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Formulario formulario;

//    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Laudo'.")
//    @Column(length = 255, nullable = false)
    @Lob
    private Arquivo laudo;


}
