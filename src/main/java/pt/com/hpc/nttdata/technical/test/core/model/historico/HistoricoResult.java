package pt.com.hpc.nttdata.technical.test.core.model.historico;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoricoResult implements Serializable {

    private Integer id;

    private LocalDateTime data;

    private String idObjeto;

    private String tipoObjeto;

    private String objeto;
}
