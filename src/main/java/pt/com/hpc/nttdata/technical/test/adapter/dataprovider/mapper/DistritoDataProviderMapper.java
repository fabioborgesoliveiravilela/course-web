package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Distrito;
import pt.com.hpc.nttdata.technical.test.core.model.distrito.DistritoResult;

@Mapper
public interface DistritoDataProviderMapper {

    DistritoResult toResult(Distrito distrito);
}
