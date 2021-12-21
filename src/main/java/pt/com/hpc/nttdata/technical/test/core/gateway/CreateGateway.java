package pt.com.hpc.nttdata.technical.test.core.gateway;

public interface CreateGateway<I,O> {

    O create(I input);
}