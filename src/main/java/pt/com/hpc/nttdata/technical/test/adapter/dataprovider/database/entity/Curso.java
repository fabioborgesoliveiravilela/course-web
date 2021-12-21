package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.*;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.HistoricoListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "tab_curso")
@SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso")
@EntityListeners(HistoricoListener.class)
public class Curso  implements Serializable, GenericEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_curso")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "vagas", nullable = false)
    private Integer vagas;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    @Column(name = "inicio", nullable = false)
    private LocalDate inicio;

    @Column(name = "termino", nullable = false)
    private LocalDate termino;

    @Enumerated
    @Column(name = "situacao", nullable = false)
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "id_distrito", nullable = false)
    private Distrito distrito;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime  updatedOn;

    @Column(name = "inactivated_on")
    private LocalDateTime  inactivatedOn;
}
