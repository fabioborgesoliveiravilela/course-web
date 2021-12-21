package pt.com.hpc.nttdata.technical.test.core.usecase.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.curso.DeleteCursoGateway;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DeleteProfessorUseCase {

    @Autowired
    private DeleteCursoGateway deleteProfessorGateway;

    public void delete(Integer id) {
        deleteProfessorGateway.delete(id);
    }
}
