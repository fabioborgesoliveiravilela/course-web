package pt.com.hpc.nttdata.technical.test.core.gateway;

public interface ReadByIdGateway<O, ID> {

    O read(ID id);
}