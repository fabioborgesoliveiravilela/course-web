package pt.com.hpc.nttdata.technical.test.core.model.professor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfessorResult implements Serializable {

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

    private BigDecimal valorAula;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private LocalDateTime inactivatedOn;

    @Setter
    private String temperaturaMinima;
    @Setter
    private String temperaturaMaxima;
}
