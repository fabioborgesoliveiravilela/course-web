package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.HistoricoListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tab_professor")
@EntityListeners(HistoricoListener.class)
public class Professor extends Pessoa {

    @Builder
    public Professor(Integer id, String nome, LocalDate dataNascimento, String email, String morada, Distrito distrito, String codigoPostal, String telemovel, LocalDateTime createdOn, LocalDateTime updatedOn, LocalDateTime inactivatedOn, BigDecimal valorAula) {
        super(id, nome, dataNascimento, email, morada, distrito, codigoPostal, telemovel, createdOn, updatedOn, inactivatedOn);
        this.valorAula = valorAula;
    }

    @Column(name = "valor_aula", nullable = false)
    private BigDecimal valorAula;
}
