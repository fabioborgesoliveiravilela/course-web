package pt.com.hpc.nttdata.technical.test.core.model.aluno;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateAluno implements Serializable {

    private String nome;

    private LocalDate dataNascimento;

    private String email;

    private String morada;

    private Integer idDistrito;

    private String codigoPostal;

    private String telemovel;

    private String nif;

    private String senha;

    private String fotografia;
}
