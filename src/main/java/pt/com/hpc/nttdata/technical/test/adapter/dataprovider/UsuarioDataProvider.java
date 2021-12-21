package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.UsuarioRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.UsuarioDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.usuario.AutenticaUsuarioGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.usuario.ReadUsuarioByNifGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.usuario.ReadUsuarioGateway;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioResult;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

import java.util.List;

@Component
public class UsuarioDataProvider implements
        ReadUsuarioGateway, AutenticaUsuarioGateway , ReadUsuarioByNifGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDataProviderMapper usuarioDataProviderMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioResult> read() {
        return usuarioDataProviderMapper.toResulList(
                usuarioRepository.findAll()
        );
    }

    @Override
    public void autentica(String nif, String senha){
        usuarioRepository.findByNif(nif)
                .filter(it-> passwordEncoder.matches(senha, it.getSenha()))
                .orElseThrow(() -> new NotFoundException(nif, "Usuário"));
    }

    @Override
    public UsuarioResult read(String nif) {
        return usuarioDataProviderMapper.toResult(
                usuarioRepository.findByNif(nif).orElseThrow(() -> new NotFoundException(nif, "Usuário"))
        );
    }
}
