package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.AlunoResult;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.CreateAluno;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.UpdateAluno;
import pt.com.hpc.nttdata.technical.test.core.usecase.aluno.CreateAlunoUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.aluno.DeleteAlunoUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.aluno.ReadAlunoUseCase;
import pt.com.hpc.nttdata.technical.test.core.usecase.aluno.UpdateAlunoUseCase;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final CreateAlunoUseCase createAlunoUseCase;

    private final ReadAlunoUseCase readAlunoUseCase;

    private final UpdateAlunoUseCase updateAlunoUseCase;

    private final DeleteAlunoUseCase deleteAlunoUseCase;

    @Autowired
    public AlunoController(CreateAlunoUseCase createAlunoUseCase,
                           ReadAlunoUseCase readAlunoUseCase,
                           UpdateAlunoUseCase updateAlunoUseCase,
                           DeleteAlunoUseCase deleteAlunoUseCase) {
        this.createAlunoUseCase = createAlunoUseCase;
        this.readAlunoUseCase = readAlunoUseCase;
        this.updateAlunoUseCase = updateAlunoUseCase;
        this.deleteAlunoUseCase = deleteAlunoUseCase;
    }

    @PostMapping
    public ResponseEntity<AlunoResult> create(@Valid @RequestBody CreateAluno createAluno) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createAlunoUseCase.create(createAluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResult>> read() {
        return ResponseEntity.ok(readAlunoUseCase.read());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResult> update(@PathVariable Integer id, @Valid @RequestBody UpdateAluno updateAluno) {
        return ResponseEntity.ok(updateAlunoUseCase.update(id, updateAluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        deleteAlunoUseCase.delete(id);

        return ResponseEntity.noContent().build();
    }
}
