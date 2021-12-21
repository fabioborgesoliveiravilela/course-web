package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Curso;
import pt.com.hpc.nttdata.technical.test.core.model.curso.CursoResult;

import java.util.List;

@Mapper
public interface CursoDataProviderMapper {

    @Mappings({
            @Mapping(target = "idDistrito", source = "distrito.id"),
            @Mapping(target = "nomeDistrito", source = "distrito.nome"),
            @Mapping(target = "idConcelho", source = "distrito.idConcelho"),
            @Mapping(target = "idGlobalLocal", source = "distrito.idGlobalLocal")
    })
    CursoResult toResult(Curso curso);

    List<CursoResult> toResultList(List<Curso> cursos);
}
