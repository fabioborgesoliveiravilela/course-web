package pt.com.hpc.nttdata.technical.test.core.gateway.aluno;

import pt.com.hpc.nttdata.technical.test.core.gateway.UpdateGateway;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.AlunoResult;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.UpdateAluno;

public interface UpdateAlunoGateway extends UpdateGateway<Integer, UpdateAluno, AlunoResult> {
}