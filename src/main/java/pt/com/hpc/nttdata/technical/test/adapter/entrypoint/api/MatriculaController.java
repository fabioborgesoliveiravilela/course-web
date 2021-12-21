package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.CreateMatricula;
import pt.com.hpc.nttdata.technical.test.core.model.matricula.MatriculaResult;
import pt.com.hpc.nttdata.technical.test.core.usecase.matricula.CreateMatriculaUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.matricula.ReadMatriculaUseCase;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final CreateMatriculaUseCase createMatriculaUseCase;

    private final ReadMatriculaUseCase readMatriculaUseCase;

    @Autowired
    public MatriculaController(CreateMatriculaUseCase createMatriculaUseCase,
                               ReadMatriculaUseCase readMatriculaUseCase) {
        this.createMatriculaUseCase = createMatriculaUseCase;
        this.readMatriculaUseCase = readMatriculaUseCase;
    }

    @PostMapping
    public ResponseEntity<MatriculaResult> create(@Valid @RequestBody CreateMatricula createMatricula) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createMatriculaUseCase.create(createMatricula));
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResult>> read() {
        return ResponseEntity.ok(readMatriculaUseCase.read());
    }
}
