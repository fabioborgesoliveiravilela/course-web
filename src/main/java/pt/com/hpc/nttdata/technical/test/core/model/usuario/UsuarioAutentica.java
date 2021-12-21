package pt.com.hpc.nttdata.technical.test.core.model.usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UsuarioAutentica implements Serializable {

    private String nif;

    private String senha;
}
