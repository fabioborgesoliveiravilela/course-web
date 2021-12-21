package pt.com.hpc.nttdata.technical.test.core.usecase.area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.area.ReadAreaGateway;
import pt.com.hpc.nttdata.technical.test.core.model.area.AreaResult;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReadAreaUseCase {

    @Autowired
    private ReadAreaGateway readAreaGateway;

    public List<AreaResult> read() {
        return readAreaGateway.read();
    }
}
