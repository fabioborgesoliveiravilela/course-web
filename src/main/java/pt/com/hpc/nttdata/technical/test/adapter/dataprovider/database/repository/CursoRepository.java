package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Curso;

public interface  CursoRepository extends JpaRepository<Curso, Integer> {
}
