package pt.com.hpc.nttdata.technical.test.core.model.matricula;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaResult implements Serializable {

    private final Integer id;

    private final Integer idAluno;

    private final String nomeAluno;

    private final Integer idCurso;

    private final String nomeCurso;
}
