package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "TAB_HISTORICO")
@SequenceGenerator(name = "seq_historico", sequenceName = "seq_historico")
public class Historico implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico")
    private Integer id;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Column(name = "id_objeto", nullable = false)
    private String idObjeto;

    @Column(name = "tipo_objeto", nullable = false)
    private String tipoObjeto;

    @Column(name = "objeto", nullable = false)
    private String objeto;
}
