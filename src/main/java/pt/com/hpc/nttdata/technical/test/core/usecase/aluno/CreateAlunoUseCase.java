package pt.com.hpc.nttdata.technical.test.core.usecase.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.aluno.CreateAlunoGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.distrito.ReadDistritoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.AlunoResult;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.CreateAluno;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CreateAlunoUseCase {

    @Autowired
    private CreateAlunoGateway createAlunoGateway;

    @Autowired
    private ReadDistritoByIdGateway readDistritoByIdGateway;

    public AlunoResult create(CreateAluno createAluno) {

        if(readDistritoByIdGateway.read(createAluno.getIdDistrito()) == null){
            throw new NotFoundException(createAluno.getIdDistrito() , "Distrito");
        }

        return createAlunoGateway.create(createAluno);
    }
}
