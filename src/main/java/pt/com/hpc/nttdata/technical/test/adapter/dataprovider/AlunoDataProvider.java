package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Aluno;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Usuario;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.UsuarioRepository;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.AlunoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.DistritoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.AlunoDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.aluno.*;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.*;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Component
public class AlunoDataProvider implements CreateAlunoGateway, ReadAlunoGateway, ReadAlunoByIdGateway, UpdateAlunoGateway, DeleteAlunoGateway {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DistritoRepository distritoRepository;

    @Autowired
    private AlunoDataProviderMapper alunoDataProviderMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AlunoResult create(CreateAluno input) {

        Aluno entity = Aluno.builder()
                .nome(input.getNome())
                .dataNascimento(input.getDataNascimento())
                .email(input.getEmail())
                .morada(input.getMorada())
                .distrito(distritoRepository.getById(input.getIdDistrito()))
                .codigoPostal(input.getCodigoPostal())
                .telemovel(input.getTelemovel())
                .fotografia(Base64.getDecoder().decode(input.getFotografia()))
                .createdOn(LocalDateTime.now())
                .build();

        entity = alunoRepository.saveAndFlush(entity);

        Usuario usuario = Usuario.builder()
                .pessoa(entity)
                .nif(input.getNif())
                .senha(passwordEncoder.encode(input.getSenha()))
                .build();
        usuarioRepository.saveAndFlush(usuario);

        return alunoDataProviderMapper.toResult(entity);
    }

    @Override
    public AlunoResult read(Integer id) {
        return alunoDataProviderMapper.toResult(
                findById(id)
        );
    }

    @Override
    public List<AlunoResult> read() {

        return alunoDataProviderMapper.toResultList(
                alunoRepository.findAll()
        );
    }

    @Override
    public AlunoResult update(Integer id, UpdateAluno input) {

        Aluno entity = findById(id);
        entity.setNome(input.getNome());
        entity.setDataNascimento(input.getDataNascimento());
        entity.setMorada(input.getMorada());
        entity.setDistrito(distritoRepository.getById(input.getIdDistrito()));
        entity.setCodigoPostal(input.getCodigoPostal());
        entity.setTelemovel(input.getTelemovel());
        entity.setFotografia(Base64.getDecoder().decode(input.getFotografia()));
        entity.setUpdatedOn(LocalDateTime.now());

        entity = alunoRepository.saveAndFlush(entity);

        return alunoDataProviderMapper.toResult(entity);
    }

    @Override
    public void delete(Integer id) {
        Aluno entity = findById(id);
        entity.setInactivatedOn(LocalDateTime.now());

        alunoRepository.saveAndFlush(entity);
    }

    private Aluno findById(Integer id) {
        return alunoRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "Aluno"));
    }
}
