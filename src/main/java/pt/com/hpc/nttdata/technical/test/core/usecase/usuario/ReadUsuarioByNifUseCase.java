package pt.com.hpc.nttdata.technical.test.core.usecase.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.usuario.ReadUsuarioByNifGateway;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioResult;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReadUsuarioByNifUseCase {

    @Autowired
    private ReadUsuarioByNifGateway readUsuarioByNifGateway;

    public UsuarioResult read(String nif) {
        return readUsuarioByNifGateway.read(nif);
    }
}
