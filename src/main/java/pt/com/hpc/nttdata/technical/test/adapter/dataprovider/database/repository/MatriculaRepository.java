package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
