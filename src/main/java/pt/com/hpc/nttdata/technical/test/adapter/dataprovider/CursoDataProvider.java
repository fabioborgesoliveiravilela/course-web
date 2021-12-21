package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Curso;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Situacao;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.AreaRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.CursoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.DistritoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.CursoDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.curso.*;
import pt.com.hpc.nttdata.technical.test.core.model.curso.*;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CursoDataProvider implements CreateCursoGateway, ReadCursoGateway, ReadCursoByIdGateway, UpdateCursoGateway, DeleteCursoGateway {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private DistritoRepository distritoRepository;

    @Autowired
    private CursoDataProviderMapper cursoDataProviderMapper;

    @Override
    public CursoResult create(CreateCurso input) {

        Curso curso = Curso.builder()
                .nome(input.getNome())
                .descricao(input.getDescricao())
                .vagas(input.getVagas())
                .area(areaRepository.getById(input.getIdArea()))
                .inicio(input.getInicio())
                .termino(input.getTermino())
                .situacao(Situacao.ATIVO)
                .distrito(distritoRepository.getById(input.getIdDistrito()))
                .createdOn(LocalDateTime.now()).build();

        curso = cursoRepository.saveAndFlush(curso);

        return cursoDataProviderMapper.toResult(curso);
    }

    @Override
    public CursoResult read(Integer id) {
        return cursoDataProviderMapper.toResult(
                findById(id)
        );
    }

    @Override
    public List<CursoResult> read() {

        return cursoDataProviderMapper.toResultList(
                cursoRepository.findAll()
        );
    }

    @Override
    public CursoResult update(Integer id, UpdateCurso input) {

        Curso curso = findById(id);
        curso.setNome(input.getNome());
        curso.setDescricao(input.getDescricao());
        curso.setVagas(input.getVagas());
        curso.setArea(areaRepository.getById(input.getIdArea()));
        curso.setInicio(input.getInicio());
        curso.setTermino(input.getTermino());
        curso.setDistrito(distritoRepository.getById(input.getIdDistrito()));
        curso.setUpdatedOn(LocalDateTime.now());

        curso = cursoRepository.saveAndFlush(curso);

        return cursoDataProviderMapper.toResult(curso);
    }

    @Override
    public void delete(Integer id) {
        Curso curso = findById(id);
        curso.setInactivatedOn(LocalDateTime.now());

        cursoRepository.saveAndFlush(curso);
    }

    private Curso findById(Integer id) {
        return cursoRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "Curso"));
    }
}
