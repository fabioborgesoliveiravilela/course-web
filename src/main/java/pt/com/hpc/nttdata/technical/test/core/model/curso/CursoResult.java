package pt.com.hpc.nttdata.technical.test.core.model.curso;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoResult implements Serializable {

    private final Integer id;

    private final String nome;

    private final String descricao;

    private final Integer vagas;

    private final Integer idArea;

    private final String nomeArea;

    private final LocalDate inicio;

    private final LocalDate termino;

    private final String situacao;

    private final Integer idDistrito;

    private final String nomeDistrito;

    private final Integer idConcelho;

    private final Integer idGlobalLocal;

    private final LocalDateTime createdOn;

    private final LocalDateTime updatedOn;

    private final LocalDateTime inactivatedOn;

    @Setter
    private String temperaturaMinima;
    @Setter
    private String temperaturaMaxima;
}
