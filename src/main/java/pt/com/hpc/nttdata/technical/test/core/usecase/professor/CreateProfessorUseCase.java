package pt.com.hpc.nttdata.technical.test.core.usecase.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.distrito.ReadDistritoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.professor.CreateProfessorGateway;
import pt.com.hpc.nttdata.technical.test.core.model.professor.CreateProfessor;
import pt.com.hpc.nttdata.technical.test.core.model.professor.ProfessorResult;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CreateProfessorUseCase {

    @Autowired
    private CreateProfessorGateway createProfessorGateway;

    @Autowired
    private ReadDistritoByIdGateway readDistritoByIdGateway;

    public ProfessorResult create(CreateProfessor createProfessor) {

        if(readDistritoByIdGateway.read(createProfessor.getIdDistrito()) == null){
            throw new NotFoundException(createProfessor.getIdDistrito() , "Distrito");
        }

        return createProfessorGateway.create(createProfessor);
    }
}
