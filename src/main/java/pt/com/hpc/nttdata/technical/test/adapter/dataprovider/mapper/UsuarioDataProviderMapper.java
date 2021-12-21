package pt.com.hpc.nttdata.technical.test.adapter.dataprovider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pt.com.hpc.nttdata.technical.test.adapter.dataprovider.database.entity.Usuario;
import pt.com.hpc.nttdata.technical.test.core.model.usuario.UsuarioResult;

import java.util.List;

@Mapper
public interface UsuarioDataProviderMapper {

    @Mappings({
            @Mapping(target = "id", source = "pessoa.id"),
            @Mapping(target = "dataNascimento", source = "pessoa.dataNascimento"),
            @Mapping(target = "email", source = "pessoa.email"),
            @Mapping(target = "perfil", expression = "java(usuario.getPerfil())"),
            @Mapping(target = "createdOn", source = "pessoa.createdOn"),
            @Mapping(target = "updatedOn", source = "pessoa.updatedOn"),
            @Mapping(target = "inactivatedOn", source = "pessoa.inactivatedOn")
    })
    UsuarioResult toResult(Usuario usuario);

    List<UsuarioResult> toResulList(List<Usuario> usuarios);
}
