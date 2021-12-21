package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.com.hpc.nttdata.technical.test.core.model.historico.HistoricoResult;
import pt.com.hpc.nttdata.technical.test.core.usecase.historico.ReadHistoricoUseCase;

import java.util.List;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    private final ReadHistoricoUseCase readHistoricoUseCase;

    @Autowired
    public HistoricoController(ReadHistoricoUseCase readHistoricoUseCase) {
        this.readHistoricoUseCase = readHistoricoUseCase;
    }

    @GetMapping
    public ResponseEntity<List<HistoricoResult>> read() {
        return ResponseEntity.ok(readHistoricoUseCase.read());
    }
}
