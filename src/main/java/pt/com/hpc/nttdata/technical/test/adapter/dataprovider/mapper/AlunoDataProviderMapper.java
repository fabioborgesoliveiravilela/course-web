package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Aluno;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.AlunoResult;

import java.util.List;

@Mapper
public interface AlunoDataProviderMapper {

    @Mappings({
            @Mapping(target = "idDistrito", source = "distrito.id"),
            @Mapping(target = "nomeDistrito", source = "distrito.nome"),
            @Mapping(target = "idConcelho", source = "distrito.idConcelho"),
            @Mapping(target = "idGlobalLocal", source = "distrito.idGlobalLocal")
    })
    AlunoResult toResult(Aluno aluno);

    List<AlunoResult> toResultList(List<Aluno> alunos);
}
