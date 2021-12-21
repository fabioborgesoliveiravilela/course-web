package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Area;
import pt.com.hpc.nttdata.technical.test.core.model.area.AreaResult;

import java.util.List;

@Mapper
public interface AreaDataProviderMapper {

    AreaResult toResult(Area area);

    List<AreaResult> toResultList(List<Area> areas);
}
