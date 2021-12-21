package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.feign.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IpmaDistritoDataResponse {

    private final Integer idRegiao;
    private final String idAreaAviso;
    private final Integer idConcelho;
    private final Integer globalIdLocal;
    private final String latitude;
    private final Integer idDistrito;
    private final String local;
    private final String longitude;
}
