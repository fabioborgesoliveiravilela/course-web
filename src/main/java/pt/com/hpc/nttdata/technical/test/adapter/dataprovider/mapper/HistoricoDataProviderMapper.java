package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Historico;
import pt.com.hpc.nttdata.technical.test.core.model.historico.HistoricoResult;

import java.util.List;

@Mapper
public interface HistoricoDataProviderMapper {

    HistoricoResult toResult(Historico historico);

    List<HistoricoResult> toResultList(List<Historico> historicos);
}
