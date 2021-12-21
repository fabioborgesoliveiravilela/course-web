package pt.com.hpc.nttdata.technical.test.core.usecase.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.aluno.UpdateAlunoGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.distrito.ReadDistritoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.AlunoResult;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.UpdateAluno;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UpdateAlunoUseCase {

    @Autowired
    private UpdateAlunoGateway updateAlunoGateway;

    @Autowired
    private ReadDistritoByIdGateway readDistritoByIdGateway;

    public AlunoResult update(Integer id, UpdateAluno updateAluno) {

        if(readDistritoByIdGateway.read(updateAluno.getIdDistrito()) == null){
            throw new NotFoundException(updateAluno.getIdDistrito() , "Distrito");
        }

        return updateAlunoGateway.update(id, updateAluno);
    }
}
