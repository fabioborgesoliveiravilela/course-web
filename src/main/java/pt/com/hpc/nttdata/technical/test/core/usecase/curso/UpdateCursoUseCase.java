package pt.com.hpc.nttdata.technical.test.core.usecase.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.area.ReadAreaByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.curso.UpdateCursoGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.distrito.ReadDistritoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.model.curso.CursoResult;
import pt.com.hpc.nttdata.technical.test.core.model.curso.UpdateCurso;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UpdateCursoUseCase {

    @Autowired
    private UpdateCursoGateway updateCursoGateway;

    @Autowired
    private ReadAreaByIdGateway readAreaByIdGateway;

    @Autowired
    private ReadDistritoByIdGateway readDistritoByIdGateway;

    public CursoResult update(Integer id, UpdateCurso updateCurso) {

        if(readAreaByIdGateway.read(updateCurso.getIdArea()) == null){
            throw new NotFoundException(updateCurso.getIdArea() , "Area");
        }

        if(readDistritoByIdGateway.read(updateCurso.getIdDistrito()) == null){
            throw new NotFoundException(updateCurso.getIdDistrito() , "Distrito");
        }

        return updateCursoGateway.update(id, updateCurso);
    }
}
