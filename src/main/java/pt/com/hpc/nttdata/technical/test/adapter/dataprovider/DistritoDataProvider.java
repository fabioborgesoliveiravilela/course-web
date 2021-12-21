package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.feign.IpmaFeignAPI;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.feign.response.IpmaDistritoDataResponse;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.api.feign.response.IpmaDistritoResponse;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Distrito;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.DistritoRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.DistritoDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.distrito.ReadDistritoByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.model.distrito.DistritoResult;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

import java.util.Optional;

@Component
public class DistritoDataProvider implements
        ReadDistritoByIdGateway {

    @Autowired
    private DistritoRepository distritoRepository;

    @Autowired
    private IpmaFeignAPI ipmaFeignAPI;

    @Autowired
    private DistritoDataProviderMapper distritoDataProviderMapper;

    @Override
    public DistritoResult read(Integer id) {

        return distritoDataProviderMapper.toResult(distritoRepository.findById(id)
                .or(() -> {
                    Optional<IpmaDistritoResponse> response = ipmaFeignAPI.readDistritos();

                    if (response.isPresent()) {
                        IpmaDistritoDataResponse responseData = response.get().getData()
                                .stream()
                                .filter(it -> it.getIdDistrito().equals(id))
                                .findFirst().orElseThrow(() -> new NotFoundException(id, "Distrito"));

                        Distrito distrito = Distrito.builder()
                                .id(responseData.getIdDistrito())
                                .nome(responseData.getLocal())
                                .idConcelho(responseData.getIdConcelho())
                                .idGlobalLocal(responseData.getGlobalIdLocal()).build();

                        return Optional.of(distritoRepository.saveAndFlush(distrito));
                    }
                    return Optional.empty();
                })
                .orElseThrow(() -> new NotFoundException(id, "Distrito")));
    }
}
