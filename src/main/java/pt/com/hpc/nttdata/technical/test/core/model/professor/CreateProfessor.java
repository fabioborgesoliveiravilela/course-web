package pt.com.hpc.nttdata.technical.test.core.model.professor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateProfessor implements Serializable {

    private String nome;

    private LocalDate dataNascimento;

    private String email;

    private String morada;

    private Integer idDistrito;

    private String codigoPostal;

    private String telemovel;

    private String nif;

    private String senha;

    private BigDecimal valorAula;
}
