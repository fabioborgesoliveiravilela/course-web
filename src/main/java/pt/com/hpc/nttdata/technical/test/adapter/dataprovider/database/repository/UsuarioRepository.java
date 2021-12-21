package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNifAndSenha(String nif, String senha);

    Optional<Usuario> findByNif(String nif);
}
