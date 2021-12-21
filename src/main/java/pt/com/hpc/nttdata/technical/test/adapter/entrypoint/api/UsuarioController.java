package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hpc.nttdata.technical.test.adapter.entrypoint.filter.JwtUtils;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioAutentica;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioResult;
import pt.com.hpc.nttdata.technical.test.core.usecase.usuario.AutenticaUsuarioUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.usuario.ReadUsuarioUseCase;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final AutenticaUsuarioUseCase autenticaUsuarioUseCase;

    private final ReadUsuarioUseCase readUsuarioUseCase;

    private final JwtUtils jwtUtils;

    @Autowired
    public UsuarioController(AutenticaUsuarioUseCase autenticaUsuarioUseCase,
                             ReadUsuarioUseCase readUsuarioUseCase,
                             JwtUtils jwtUtils) {
        this.autenticaUsuarioUseCase = autenticaUsuarioUseCase;
        this.readUsuarioUseCase = readUsuarioUseCase;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/token")
    public ResponseEntity<String> autentica(@RequestBody UsuarioAutentica usuarioAutentica) {

        autenticaUsuarioUseCase.autentica(usuarioAutentica);

        return ResponseEntity.ok(jwtUtils.generateJwtToken(usuarioAutentica.getNif()));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResult>> read() {
        return ResponseEntity.ok(readUsuarioUseCase.read());
    }
}
