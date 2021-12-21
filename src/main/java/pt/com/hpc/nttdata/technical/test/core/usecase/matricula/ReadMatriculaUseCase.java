package pt.com.hpc.nttdata.technical.test.core.usecase.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.Matricula.ReadMatriculaGateway;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.MatriculaResult;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReadMatriculaUseCase {

    @Autowired
    private ReadMatriculaGateway readMatriculaGateway;

    public List<MatriculaResult> read() {
        return readMatriculaGateway.read();
    }
}
