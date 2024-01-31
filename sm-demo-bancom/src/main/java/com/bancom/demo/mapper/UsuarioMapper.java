package com.bancom.demo.mapper;


import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.bancom.demo.persistence.models.Usuario;
import com.bancom.demo.presentation.dto.UsuarioDTO;



@Component
@Mapper
public interface UsuarioMapper extends GenericMapper<Usuario, UsuarioDTO>{
	
	   UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	    @Mappings({
	        @Mapping(target = "id", ignore = true), 
	        @Mapping(target = "cellphone", source = "usuarioDTO.cellphone"),
	        @Mapping(target = "name", source = "usuarioDTO.name"),
	        @Mapping(target = "lastName", source = "usuarioDTO.lastName"),
	        @Mapping(target = "password", source = "usuarioDTO.password")
	    })
	    Usuario toEntity(UsuarioDTO usuarioDTO);

	    @Mappings({
	        @Mapping(target = "id", source = "usuario.id"), 
	        @Mapping(target = "cellphone", source = "usuario.cellphone"),
	        @Mapping(target = "name", source = "usuario.name"),
	        @Mapping(target = "lastName", source = "usuario.lastName")
//	        @Mapping(target = "password", source = "usuarioDTO.password")
	    })
	    @Named(value = "useMe")
	    UsuarioDTO toDto(Usuario usuario);

	    @IterableMapping(qualifiedByName = "useMe")
	    List<UsuarioDTO> toDtoList(List<Usuario> usuario);

}
