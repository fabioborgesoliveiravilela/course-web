package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "TAB_AREA")
public class Area  implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;
}
