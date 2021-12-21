package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.feign.response;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
public class IpmaDistritoResponse {

    private String owner;
    private String country;
    private List<IpmaDistritoDataResponse> data;
}
