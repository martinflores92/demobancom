package com.bancom.demo.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.bancom.demo.persistence.models.Post;
import com.bancom.demo.presentation.dto.PostDTO;

@Component
@Mapper
public interface PostMapper extends GenericMapper<Post, PostDTO>{
	
	PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "post.id"),
        @Mapping(target = "text", source = "post.text"),
        @Mapping(target = "usuarioId", source = "post.usuario.id")
	})
    @Named(value = "useMe")
	PostDTO postToPostDTO(Post post);
	
	@Mappings({
//	        @Mapping(target = "id", source = "postDTO.id"),
	        @Mapping(target = "text", source = "postDTO.text"),
//	        @Mapping(target = "usuarioId", source = "postDTO.usuario.usuarioId")
	})
	Post postDTOToPost(PostDTO postDTO);
	
    @IterableMapping(qualifiedByName = "useMe")
	List<PostDTO> toDtoList(List<Post> post);
	
}
