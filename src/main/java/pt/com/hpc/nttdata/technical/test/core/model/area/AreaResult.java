package pt.com.hpc.nttdata.technical.test.core.model.area;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AreaResult implements Serializable {

    private Integer id;

    private String nome;
}
