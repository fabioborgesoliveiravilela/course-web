package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "tab_distrito")
public class Distrito implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "id_concelho", nullable = false)
    private Integer idConcelho;

    @Column(name = "id_global_local", nullable = false)
    private Integer idGlobalLocal;
}
