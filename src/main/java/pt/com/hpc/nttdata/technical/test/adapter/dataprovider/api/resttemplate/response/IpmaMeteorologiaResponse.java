package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.resttemplate.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class IpmaMeteorologiaResponse {

    private String owner;
    private String country;
    private Integer globalIdLocal;
    private String dataUpdate;
    private List<IpmaMeteorologiaDataResponse> data;
}
