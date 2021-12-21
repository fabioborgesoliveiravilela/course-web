package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hpc.nttdata.technical.test.core.model.curso.*;
import pt.com.hpc.nttdata.technical.test.core.usecase.curso.CreateCursoUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.curso.DeleteCursoUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.curso.ReadCursoUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.curso.UpdateCursoUseCase;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CreateCursoUseCase createCursoUseCase;

    private final ReadCursoUseCase readCursoUseCase;

    private final UpdateCursoUseCase updateCursoUseCase;

    private final DeleteCursoUseCase deleteCursoUseCase;

    @Autowired
    public CursoController(CreateCursoUseCase createCursoUseCase,
                           ReadCursoUseCase readCursoUseCase,
                           UpdateCursoUseCase updateCursoUseCase,
                           DeleteCursoUseCase deleteCursoUseCase) {
        this.createCursoUseCase = createCursoUseCase;
        this.readCursoUseCase = readCursoUseCase;
        this.updateCursoUseCase = updateCursoUseCase;
        this.deleteCursoUseCase = deleteCursoUseCase;
    }

    @PostMapping
    public ResponseEntity<CursoResult> create(@Valid @RequestBody CreateCurso createCurso) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createCursoUseCase.create(createCurso));
    }

    @GetMapping
    public ResponseEntity<List<CursoResult>> read() {
        return ResponseEntity.ok(readCursoUseCase.read());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResult> update(@PathVariable Integer id, @Valid @RequestBody UpdateCurso updateCurso) {
        return ResponseEntity.ok(updateCursoUseCase.update(id, updateCurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        deleteCursoUseCase.delete(id);

        return ResponseEntity.noContent().build();
    }
}
