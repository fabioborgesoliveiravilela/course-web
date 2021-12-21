package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.GenericEntity;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Historico;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.repository.HistoricoRepository;

import javax.persistence.PostUpdate;
import java.time.LocalDateTime;

@Component
public class HistoricoListener {

    private static HistoricoRepository historicoRepository;
    private ObjectMapper mapper;

    public HistoricoListener(){
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Autowired
    public void setHistoricoRepository(HistoricoRepository historicoRepository) {
        HistoricoListener.historicoRepository = historicoRepository;
    }



    @PostUpdate
    public void after(GenericEntity object) throws JsonProcessingException {

        Historico historico = Historico.builder()
                .idObjeto(object.getId().toString())
                .data(LocalDateTime.now())
                .tipoObjeto(object.getClass().getSimpleName())
                .objeto(mapper.writer().writeValueAsString(object)).build();

        historicoRepository.save(historico);
    }
}
