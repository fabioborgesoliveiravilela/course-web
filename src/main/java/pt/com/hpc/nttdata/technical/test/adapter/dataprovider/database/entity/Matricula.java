package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "TAB_MATRICULA")
@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula")
public class Matricula implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "REL_PROFESSORES",
            joinColumns = {@JoinColumn(name = "id_matricula")},
            inverseJoinColumns = {@JoinColumn(name = "id_professor")})
    private List<Professor> professores;
}
