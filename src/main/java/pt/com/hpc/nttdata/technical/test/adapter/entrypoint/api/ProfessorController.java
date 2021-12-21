package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hpc.nttdata.technical.test.core.model.professor.*;
import pt.com.hpc.nttdata.technical.test.core.usecase.professor.CreateProfessorUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.professor.DeleteProfessorUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.professor.ReadProfessorUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.professor.UpdateProfessorUseCase;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final CreateProfessorUseCase createProfessorUseCase;

    private final ReadProfessorUseCase readProfessorUseCase;

    private final UpdateProfessorUseCase updateProfessorUseCase;

    private final DeleteProfessorUseCase deleteProfessorUseCase;

    @Autowired
    public ProfessorController(CreateProfessorUseCase createProfessorUseCase,
                               ReadProfessorUseCase readProfessorUseCase,
                               UpdateProfessorUseCase updateProfessorUseCase,
                               DeleteProfessorUseCase deleteProfessorUseCase) {
        this.createProfessorUseCase = createProfessorUseCase;
        this.readProfessorUseCase = readProfessorUseCase;
        this.updateProfessorUseCase = updateProfessorUseCase;
        this.deleteProfessorUseCase = deleteProfessorUseCase;
    }

    @PostMapping
    public ResponseEntity<ProfessorResult> create(@Valid @RequestBody CreateProfessor createProfessor) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createProfessorUseCase.create(createProfessor));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResult>> read() {
        return ResponseEntity.ok(readProfessorUseCase.read());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResult> update(@PathVariable Integer id, @Valid @RequestBody UpdateProfessor updateProfessor) {
        return ResponseEntity.ok(updateProfessorUseCase.update(id, updateProfessor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        deleteProfessorUseCase.delete(id);

        return ResponseEntity.noContent().build();
    }
}
