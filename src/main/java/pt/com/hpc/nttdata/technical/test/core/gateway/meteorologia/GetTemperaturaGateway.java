package pt.com.hpc.nttdata.technical.test.core.gateway.meteorologia;

import pt.com.hpc.nttdata.technical.test.core.model.meteorologia.Temperatura;

public interface GetTemperaturaGateway {

    Temperatura get(Integer idGlobalLocal);
}
