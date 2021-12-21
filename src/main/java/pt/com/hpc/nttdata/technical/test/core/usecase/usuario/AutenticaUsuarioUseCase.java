package pt.com.hpc.nttdata.technical.test.core.usecase.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pt.com.hpc.nttdata.technical.test.core.gateway.usuario.AutenticaUsuarioGateway;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioAutentica;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AutenticaUsuarioUseCase {

    @Autowired
    private AutenticaUsuarioGateway autenticaUsuarioGateway;

    public void autentica(UsuarioAutentica usuarioAutentica) {
        autenticaUsuarioGateway.autentica(usuarioAutentica.getNif(), usuarioAutentica.getSenha());
    }
}
