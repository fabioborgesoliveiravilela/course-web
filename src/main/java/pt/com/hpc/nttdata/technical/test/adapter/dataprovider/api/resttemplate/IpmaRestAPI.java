package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.resttemplate.response.IpmaMeteorologiaResponse;

import java.util.HashMap;
import java.util.Map;

@Component
public class IpmaRestAPI {

    @Autowired
    private RestTemplate restTemplate;

    public IpmaMeteorologiaResponse readMeteorologia(Integer globalIdLocal) {

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("globalIdLocal", globalIdLocal);

        return restTemplate.getForObject("http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/{globalIdLocal}.json", IpmaMeteorologiaResponse.class, params);
    }
}
