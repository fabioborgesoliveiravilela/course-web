package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Professor;
import pt.com.hpc.nttdata.technical.test.core.model.professor.ProfessorResult;

import java.util.List;

@Mapper
public interface ProfessorDataProviderMapper {

    @Mappings({
            @Mapping(target = "idDistrito", source = "distrito.id"),
            @Mapping(target = "nomeDistrito", source = "distrito.nome"),
            @Mapping(target = "idConcelho", source = "distrito.idConcelho"),
            @Mapping(target = "idGlobalLocal", source = "distrito.idGlobalLocal")
    })
    ProfessorResult toResult(Professor professor);

    List<ProfessorResult> toResulList(List<Professor> professores);
}
