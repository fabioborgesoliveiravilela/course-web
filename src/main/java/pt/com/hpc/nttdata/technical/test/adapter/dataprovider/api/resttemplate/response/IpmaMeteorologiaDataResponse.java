package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.resttemplate.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IpmaMeteorologiaDataResponse {

    private final String precipitaProb;
    private final String tMin;
    private final String tMax;
    private final String predWindDir;
    private final String idWeatherType;
    private final String classWindSpeed;
    private final String longitude;
    private final String latitude;
    private final String forecastDate;
    private final Integer classPrecInt;
}
