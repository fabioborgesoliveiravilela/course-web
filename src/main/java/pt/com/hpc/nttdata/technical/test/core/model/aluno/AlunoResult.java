package pt.com.hpc.nttdata.technical.test.core.model.aluno;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunoResult implements Serializable {

    private Integer id;

    private String nome;

    private LocalDate dataNascimento;

    private String email;

    private String morada;

    private Integer idDistrito;

    private String nomeDistrito;

    private Integer idConcelho;

    private final Integer idGlobalLocal;

    private String codigoPostal;

    private String telemovel;

    /*
    private String fotografia;
    */

    private String nif;

    private String senha;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private LocalDateTime inactivatedOn;

    @Setter
    private String temperaturaMinima;
    @Setter
    private String temperaturaMaxima;
}
