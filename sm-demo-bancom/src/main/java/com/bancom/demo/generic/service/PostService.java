package com.bancom.demo.generic.service;

import java.util.List;
import com.bancom.demo.presentation.dto.PostDTO;
import com.bancom.demo.presentation.dto.UsuarioDTO;

public interface PostService {
	 PostDTO createPost(PostDTO postDTO);
	 List<PostDTO> listarPost(Long idUsuario);
	 boolean eliminarPost(Long id);
	 PostDTO modificarPost(Long id, PostDTO postDTO);
}
