package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tab_usuario")
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Pessoa pessoa;

    @Column(name = "nif", nullable = false)
    private String nif;

    @Column(name = "senha", nullable = false)
    private String senha;

    public String getPerfil() {

        if (pessoa instanceof Aluno) {
            return "Aluno";
        } else {
            return "Professor";
        }
    }
}
