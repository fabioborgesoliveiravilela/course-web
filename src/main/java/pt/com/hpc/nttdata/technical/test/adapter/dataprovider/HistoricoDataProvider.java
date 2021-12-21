package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.HistoricoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.HistoricoDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.historico.ReadHistoricoGateway;
import pt.com.hpc.nttdata.technical.test.core.model.historico.HistoricoResult;

import java.util.List;

@Component
public class HistoricoDataProvider implements
        ReadHistoricoGateway{

    @Autowired
    private HistoricoRepository historicoRepository;

    @Autowired
    private HistoricoDataProviderMapper historicoDataProviderMapper;

    @Override
    public List<HistoricoResult> read() {
        return historicoDataProviderMapper.toResultList(
                historicoRepository.findAll()
        );
    }
}
