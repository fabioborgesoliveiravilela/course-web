package pt.com.hpc.nttdata.technical.test.core.usecase.historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.historico.ReadHistoricoGateway;
import pt.com.hpc.nttdata.technical.test.core.model.historico.HistoricoResult;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReadHistoricoUseCase {

    @Autowired
    private ReadHistoricoGateway readHistoricoGateway;

    public List<HistoricoResult> read() {
        return readHistoricoGateway.read();
    }
}
