package pt.com.hpc.nttdata.technical.test.core.usecase.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.aluno.ReadAlunoGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.meteorologia.GetTemperaturaGateway;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.AlunoResult;
import pt.com.hpc.nttdata.technical.test.core.model.meteorologia.Temperatura;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReadAlunoUseCase {

    @Autowired
    private ReadAlunoGateway readAlunoGateway;

    @Autowired
    private GetTemperaturaGateway getTemperaturaGateway;

    public List<AlunoResult> read() {

        return readAlunoGateway.read().stream().map(
                it -> {
                    Temperatura temperatura = getTemperaturaGateway.get(it.getIdGlobalLocal());
                    if(temperatura != null){
                        it.setTemperaturaMinima(temperatura.getMinima());
                        it.setTemperaturaMaxima(temperatura.getMaxima());
                    }
                    return it;
                }
        ).collect(Collectors.toList());
    }
}
