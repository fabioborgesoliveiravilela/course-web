package pt.com.hpc.nttdata.technical.test.core.gateway.usuario;

import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioResult;

public interface ReadUsuarioByNifGateway {

    UsuarioResult read(String nif);
}