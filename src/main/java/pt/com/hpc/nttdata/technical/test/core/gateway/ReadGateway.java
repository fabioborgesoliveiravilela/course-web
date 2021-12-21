package pt.com.hpc.nttdata.technical.test.core.gateway;

import java.util.List;

public interface ReadGateway<O> {

    List<O> read();
}