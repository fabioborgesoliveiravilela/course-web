package pt.com.hpc.nttdata.technical.test.core.usecase.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.meteorologia.GetTemperaturaGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.professor.ReadProfessorGateway;
import pt.com.hpc.nttdata.technical.test.core.model.meteorologia.Temperatura;
import pt.com.hpc.nttdata.technical.test.core.model.professor.ProfessorResult;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReadProfessorUseCase {

    @Autowired
    private ReadProfessorGateway readProfessorGateway;

    @Autowired
    private GetTemperaturaGateway getTemperaturaGateway;

    public List<ProfessorResult> read() {
        return readProfessorGateway.read().stream().map(
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
