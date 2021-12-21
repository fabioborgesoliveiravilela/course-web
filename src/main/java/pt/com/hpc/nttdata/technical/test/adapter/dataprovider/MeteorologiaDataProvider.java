package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.resttemplate.IpmaRestAPI;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.resttemplate.response.IpmaMeteorologiaResponse;
import pt.com.hpc.nttdata.technical.test.core.gateway.meteorologia.GetTemperaturaGateway;
import pt.com.hpc.nttdata.technical.test.core.model.meteorologia.Temperatura;

import java.time.LocalDate;

@Component
public class MeteorologiaDataProvider implements GetTemperaturaGateway {

    @Autowired
    private IpmaRestAPI ipmaRestAPI;

    @Override
    public Temperatura get(Integer idGlobalLocal) {

        IpmaMeteorologiaResponse response  = ipmaRestAPI.readMeteorologia(idGlobalLocal);

        if(response != null) {
            return response.getData()
                    .stream()
                    .filter(it -> it.getForecastDate().equals(LocalDate.now().toString()))
                    .map(it -> Temperatura.builder()
                            .maxima(it.getTMax())
                            .minima(it.getTMin())
                            .build()).findFirst().orElse(null);
        }
        return null;
    }
}
