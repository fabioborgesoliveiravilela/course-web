package pt.com.hpc.nttdata.technical.test.adapter.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.AreaRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper.AreaDataProviderMapper;
import pt.com.hpc.nttdata.technical.test.core.gateway.area.ReadAreaByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.gateway.area.ReadAreaGateway;
import pt.com.hpc.nttdata.technical.test.core.model.area.AreaResult;

import java.util.List;

@Component
public class AreaDataProvider implements
        ReadAreaGateway,
        ReadAreaByIdGateway {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private AreaDataProviderMapper areaDataProviderMapper;

    @Override
    public AreaResult read(Integer id) {
        return areaDataProviderMapper.toResult(
                areaRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "Area"))
        );
    }

    @Override
    public List<AreaResult> read() {
        return areaDataProviderMapper.toResultList(
                areaRepository.findAll()
        );
    }
}
