package pt.com.hpc.nttdata.technical.test.core.model.curso;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateCurso implements Serializable {

    private String nome;

    private String descricao;

    private Integer vagas;

    private Integer idArea;

    private LocalDate inicio;

    private LocalDate termino;

    private Integer idDistrito;
}
