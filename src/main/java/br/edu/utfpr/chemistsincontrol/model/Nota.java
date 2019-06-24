package br.edu.utfpr.chemistsincontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "nota")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Nota {
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

    @NotEmpty(message = "Opa!! Não esqueça de preencher o campo 'Data'.")
    @Column(nullable = false)
    private Date dataEmissao;

    @Column(nullable = false)
    private byte[] anexo;
}
