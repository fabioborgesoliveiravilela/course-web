package pt.com.hpc.nttdata.technical.test.core.gateway.aluno;

import pt.com.hpc.nttdata.technical.test.core.gateway.ReadByIdGateway;
import pt.com.hpc.nttdata.technical.test.core.model.aluno.AlunoResult;

public interface ReadAlunoByIdGateway extends ReadByIdGateway<AlunoResult, Integer> {
}