package pt.com.hpc.nttdata.technical.test.core.model.matricula;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CreateMatricula implements Serializable {

    private Integer idAluno;

    private Integer idCurso;

    private List<Integer> idsProfessores;
}
