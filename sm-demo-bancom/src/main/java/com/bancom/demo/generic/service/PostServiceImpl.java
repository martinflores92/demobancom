package com.bancom.demo.generic.service;

import com.bancom.demo.presentation.dto.PostDTO;
import com.bancom.demo.presentation.dto.UsuarioDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancom.demo.exception.UsuarioNotFoundException;
import com.bancom.demo.mapper.PostMapper;
import com.bancom.demo.mapper.UsuarioMapper;
import com.bancom.demo.persistence.models.Post;
import com.bancom.demo.persistence.models.Usuario;
import com.bancom.demo.persistence.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepository postRepository;
	@Autowired
	UsuarioService usuarioService;

	@Override
	public PostDTO createPost(PostDTO postDTO) {
		Post post = PostMapper.INSTANCE.toDto(postDTO);
		Long usuarioId = postDTO.getUsuarioId();
        Usuario usuario = usuarioService.getUsuarioById(usuarioId)
                                          .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado"));

        // Asigna el Usuario al Post
        post.setUsuario(usuario);
		post = postRepository.save(post);
		return PostMapper.INSTANCE.postToPostDTO(post);
	}

	@Override
	public List<PostDTO> listarPost(Long idUsuario) {
        List<Post> posts = postRepository.findByUsuarioId(idUsuario);
        return PostMapper.INSTANCE.toDtoList(posts);

	}

	@Override
	public boolean eliminarPost(Long id) {
		Post postExistente = postRepository.findById(id).orElse(null);
        if (postExistente != null) {
        	postRepository.delete(postExistente);
            return true;
        } else {
            return false;
        }
	}

	@Override
	public PostDTO modificarPost(Long id, PostDTO postDTO) {
		Post postExistente = postRepository.findById(id).orElse(null);
	        if (postExistente != null) {
	        	postExistente.setText(postDTO.getText());;
	        	Post usuarioModificado = postRepository.save(postExistente);
	            return PostMapper.INSTANCE.postToPostDTO(usuarioModificado);
	        } else {
	            return null;
	        }
	}

}
