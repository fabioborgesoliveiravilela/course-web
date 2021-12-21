package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "tab_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa")
public abstract class Pessoa implements Serializable, GenericEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "morada", nullable = false)
    private String morada;

    @ManyToOne
    @JoinColumn(name = "id_distrito", nullable = false)
    private Distrito distrito;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

    @Column(name = "telemovel", nullable = false)
    private String telemovel;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime  updatedOn;

    @Column(name = "inactivated_on")
    private LocalDateTime  inactivatedOn;
}
