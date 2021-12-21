package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {
}
