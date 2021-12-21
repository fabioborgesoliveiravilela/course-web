package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Professor;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Usuario;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.DistritoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.ProfessorRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.UsuarioRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.ProfessorDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.professor.*;
import pt.com.hpc.nttdata.technical.test.core.model.professor.CreateProfessor;
import pt.com.hpc.nttdata.technical.test.core.model.professor.ProfessorResult;
import pt.com.hpc.nttdata.technical.test.core.model.professor.UpdateProfessor;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ProfessorDataProvider implements CreateProfessorGateway, ReadProfessorGateway, ReadProfessorByIdGateway, UpdateProfessorGateway, DeleteProfessorGateway {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DistritoRepository distritoRepository;

    @Autowired
    private ProfessorDataProviderMapper professorDataProviderMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ProfessorResult create(CreateProfessor input) {

        Professor entity = Professor.builder()
                .nome(input.getNome())
                .dataNascimento(input.getDataNascimento())
                .email(input.getEmail())
                .morada(input.getMorada())
                .distrito(distritoRepository.getById(input.getIdDistrito()))
                .codigoPostal(input.getCodigoPostal())
                .telemovel(input.getTelemovel())
                .valorAula(input.getValorAula())
                .createdOn(LocalDateTime.now())
                .build();

        entity = professorRepository.saveAndFlush(entity);

        Usuario usuario = Usuario.builder()
                .pessoa(entity)
                .nif(input.getNif())
                .senha(passwordEncoder.encode(input.getSenha()))
                .build();
        usuarioRepository.saveAndFlush(usuario);

        return professorDataProviderMapper.toResult(entity);
    }

    @Override
    public ProfessorResult read(Integer id) {
        return professorDataProviderMapper.toResult(
                findById(id)
        );
    }

    @Override
    public List<ProfessorResult> read() {
        return professorDataProviderMapper.toResulList(
                professorRepository.findAll()
        );
    }

    @Override
    public ProfessorResult update(Integer id, UpdateProfessor input) {

        Professor entity = findById(id);
        entity.setNome(input.getNome());
        entity.setDataNascimento(input.getDataNascimento());
        entity.setMorada(input.getMorada());
        entity.setDistrito(distritoRepository.getById(input.getIdDistrito()));
        entity.setCodigoPostal(input.getCodigoPostal());
        entity.setTelemovel(input.getTelemovel());
        entity.setValorAula(input.getValorAula());
        entity.setUpdatedOn(LocalDateTime.now());

        entity = professorRepository.saveAndFlush(entity);

        return professorDataProviderMapper.toResult(entity);
    }

    @Override
    public void delete(Integer id) {
        Professor entity = findById(id);
        entity.setInactivatedOn(LocalDateTime.now());

        professorRepository.saveAndFlush(entity);
    }

    private Professor findById(Integer id) {
        return professorRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "Professor"));
    }
}
