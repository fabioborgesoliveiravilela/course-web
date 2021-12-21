package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Matricula;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.MatriculaResult;

import java.util.List;

@Mapper
public interface MatriculaDataProviderMapper {

    @Mappings({
            @Mapping(target = "idAluno", source = "aluno.id"),
            @Mapping(target = "nomeAluno", source = "aluno.nome"),
            @Mapping(target = "idCurso", source = "curso.id"),
            @Mapping(target = "nomeCurso", source = "curso.nome")
    })
    MatriculaResult toResult(Matricula matricula);

    List<MatriculaResult> toResultList(List<Matricula> matriculas);
}
