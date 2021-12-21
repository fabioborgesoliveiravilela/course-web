package pt.com.hpc.nttdata.technical.test.core.usecase.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.area.ReadAreaByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.curso.CreateCursoGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.distrito.ReadDistritoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.model.curso.CreateCurso;
import pt.com.hpc.nttdata.technical.test.core.model.curso.CursoResult;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CreateCursoUseCase {

    @Autowired
    private CreateCursoGateway createCursoGateway;

    @Autowired
    private ReadAreaByIdGateway readAreaByIdGateway;

    @Autowired
    private ReadDistritoByIdGateway readDistritoByIdGateway;

    public CursoResult create(CreateCurso createCurso) {

        if(readAreaByIdGateway.read(createCurso.getIdArea()) == null){
            throw new NotFoundException(createCurso.getIdArea() , "Area");
        }

        if(readDistritoByIdGateway.read(createCurso.getIdDistrito()) == null){
            throw new NotFoundException(createCurso.getIdDistrito() , "Distrito");
        }

        return createCursoGateway.create(createCurso);
    }
}
