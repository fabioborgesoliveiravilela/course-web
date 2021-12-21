package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.HistoricoListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tab_aluno")
@EntityListeners(HistoricoListener.class)
public class Aluno extends Pessoa {

    @Builder
    public Aluno(Integer id, String nome, LocalDate dataNascimento, String email, String morada, Distrito distrito, String codigoPostal, String telemovel, LocalDateTime createdOn, LocalDateTime updatedOn, LocalDateTime inactivatedOn, byte[] fotografia) {
        super(id, nome, dataNascimento, email, morada, distrito, codigoPostal, telemovel, createdOn, updatedOn, inactivatedOn);
        this.fotografia = fotografia;
    }

    @Lob
    @Column(name = "fotografia", nullable = false)
    private byte[] fotografia;
}
