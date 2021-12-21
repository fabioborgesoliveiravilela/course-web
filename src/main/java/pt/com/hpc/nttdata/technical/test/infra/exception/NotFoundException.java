package pt.com.hpc.nttdata.technical.test.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {

    private Serializable id;
    private String type;
}
