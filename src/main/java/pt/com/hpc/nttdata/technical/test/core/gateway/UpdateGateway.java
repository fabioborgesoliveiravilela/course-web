package pt.com.hpc.nttdata.technical.test.core.gateway;

public interface UpdateGateway<ID, I,O> {

    O update(ID id, I input);
}