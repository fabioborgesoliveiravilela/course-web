package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.com.hpc.nttdata.technical.test.core.model.area.AreaResult;
import pt.com.hpc.nttdata.technical.test.core.usecase.area.ReadAreaUseCase;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    private final ReadAreaUseCase readAreaUseCase;

    @Autowired
    public AreaController(ReadAreaUseCase readAreaUseCase) {
        this.readAreaUseCase = readAreaUseCase;
    }

    @GetMapping
    public ResponseEntity<List<AreaResult>> read() {
        return ResponseEntity.ok(readAreaUseCase.read());
    }
}
