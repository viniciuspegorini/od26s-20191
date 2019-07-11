package br.edu.utfpr.chemistsincontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "nota")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Nota {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Não esqueça de preencher o campo 'Numero'.")
    @Column(length = 100, nullable = false)
    private String numero;

    @NotEmpty(message = "Não esqueça de preencher o campo 'Tipo nota'.")
    @Column(length = 100, nullable = false)
    private String tipoNota;

    @NotNull(message = "Não esqueça de preencher o campo 'Usuário'.")
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Usuario usuario;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Valor'.")
    @Column(nullable = false)
    private Double valor;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Data'.")
    @Column(nullable = false)
    private LocalDate dataEmissao;

    @Column(nullable = true)
    private byte[] anexo;
    @Column
    private String fileName;

    @Column
    private Long size;

    @Lob
    @Column
    @JsonIgnore
    private byte[] content;
    @Column
    @Enumerated
    private Arquivo.EContentType contentType;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setContentType(Arquivo.EContentType contentType) {
        this.contentType = contentType;
    }
}
