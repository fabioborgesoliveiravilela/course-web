package pt.com.hpc.nttdata.technical.test.core.usecase.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.distrito.ReadDistritoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.professor.UpdateProfessorGateway;
import pt.com.hpc.nttdata.technical.test.core.model.professor.ProfessorResult;
import pt.com.hpc.nttdata.technical.test.core.model.professor.UpdateProfessor;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UpdateProfessorUseCase {

    @Autowired
    private UpdateProfessorGateway updateProfessorateway;

    @Autowired
    private ReadDistritoByIdGateway readDistritoByIdGateway;

    public ProfessorResult update(Integer id, UpdateProfessor updateProfessor) {

        if(readDistritoByIdGateway.read(updateProfessor.getIdDistrito()) == null){
            throw new NotFoundException(updateProfessor.getIdDistrito() , "Distrito");
        }

        return updateProfessorateway.update(id, updateProfessor);
    }
}
