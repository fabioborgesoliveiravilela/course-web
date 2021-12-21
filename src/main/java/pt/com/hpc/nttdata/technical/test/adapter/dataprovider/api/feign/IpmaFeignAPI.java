package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.feign.response.IpmaDistritoResponse;

import java.util.Optional;

@FeignClient(name = "IPMA", url = "http://api.ipma.pt/open-data")
public interface IpmaFeignAPI {

    @GetMapping("/distrits-islands.json")
    Optional<IpmaDistritoResponse> readDistritos();
}
