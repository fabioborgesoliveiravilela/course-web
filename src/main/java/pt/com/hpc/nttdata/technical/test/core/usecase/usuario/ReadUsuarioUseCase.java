package pt.com.hpc.nttdata.technical.test.core.usecase.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.usuario.ReadUsuarioGateway;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioResult;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReadUsuarioUseCase {

    @Autowired
    private ReadUsuarioGateway readUsuarioGateway;

    public List<UsuarioResult> read() {
        return readUsuarioGateway.read();
    }
}
