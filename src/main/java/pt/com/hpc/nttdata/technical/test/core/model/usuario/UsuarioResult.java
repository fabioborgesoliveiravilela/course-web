package pt.com.hpc.nttdata.technical.test.core.model.usuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioResult implements Serializable {

    private Integer id;

    private String nome;

    private LocalDate dataNascimento;

    private String email;

    private String nif;

    private String perfil;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private LocalDateTime inactivatedOn;
}
