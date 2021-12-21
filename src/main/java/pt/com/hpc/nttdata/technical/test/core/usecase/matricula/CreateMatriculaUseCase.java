package pt.com.hpc.nttdata.technical.test.core.usecase.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.Matricula.CreateMatriculaGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.aluno.ReadAlunoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.curso.ReadCursoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.professor.ReadProfessorByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.CreateMatricula;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.MatriculaResult;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CreateMatriculaUseCase {

    @Autowired
    private CreateMatriculaGateway createMatriculaGateway;

    @Autowired
    private ReadAlunoByIdGateway readAlunoByIdGateway;

    @Autowired
    private ReadCursoByIdGateway readCursoByIdGateway;

    @Autowired
    private ReadProfessorByIdGateway readProfessorByIdGateway;

    public MatriculaResult  create(CreateMatricula createMatricula) {

        readAlunoByIdGateway.read(createMatricula.getIdAluno());

        readCursoByIdGateway.read(createMatricula.getIdCurso());

        if(createMatricula.getIdsProfessores() != null){
            createMatricula.getIdsProfessores().forEach(
                    it -> readProfessorByIdGateway.read(it)
            );
        }

        return createMatriculaGateway.create(createMatricula);
    }
}
