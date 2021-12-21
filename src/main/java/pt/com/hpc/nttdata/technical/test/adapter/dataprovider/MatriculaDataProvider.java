package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Matricula;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.AlunoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.CursoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.MatriculaRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.ProfessorRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.MatriculaDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.Matricula.CreateMatriculaGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.Matricula.ReadMatriculaGateway;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.CreateMatricula;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.MatriculaResult;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatriculaDataProvider implements CreateMatriculaGateway, ReadMatriculaGateway {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private MatriculaDataProviderMapper matriculaDataProviderMapper;

    @Override
    public MatriculaResult create(CreateMatricula input) {

        Matricula matricula = Matricula.builder()
                .aluno(alunoRepository.getById(input.getIdAluno()))
                .curso(cursoRepository.getById(input.getIdCurso()))
                .professores(input.getIdsProfessores().stream().map(
                        it -> professorRepository.getById(it)).collect(Collectors.toList())
                ).build();

        matricula = matriculaRepository.saveAndFlush(matricula);

        return matriculaDataProviderMapper.toResult(matricula);
    }

    @Override
    public List<MatriculaResult> read() {

        return matriculaDataProviderMapper.toResultList(
                matriculaRepository.findAll()
        );
    }
}
