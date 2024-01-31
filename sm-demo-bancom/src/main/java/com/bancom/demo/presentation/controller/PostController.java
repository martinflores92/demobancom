package com.bancom.demo.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bancom.demo.exception.UsuarioNotFoundException;
import com.bancom.demo.generic.service.PostService;
import com.bancom.demo.presentation.dto.PostDTO;
import com.bancom.demo.presentation.dto.UsuarioDTO;
import com.bancom.demo.util.ApiResponse;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService PostService;
	
    @PostMapping
    public  ResponseEntity<Object> createPost(@RequestBody PostDTO post) {
    	try {
			PostDTO postDTO = PostService.createPost(post);
	        if (postDTO != null) {
	            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Post creado con éxito", HttpStatus.CREATED.value(),postDTO));
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No se pudo crear el Post", HttpStatus.NOT_FOUND.value(),postDTO));
	        }
		} catch (UsuarioNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),null));
		}

    }
    
    @GetMapping
    public  ResponseEntity<Object> listarPost(@RequestParam(name ="idUsuario",required = false, defaultValue = "") Long idUsuario) {
    	List<PostDTO> post=  PostService.listarPost(idUsuario);
        if (!post.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Post creado con éxito", HttpStatus.CREATED.value(),post));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No se encontro informacion de post", HttpStatus.INTERNAL_SERVER_ERROR.value(),null));
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  eliminarPost(@PathVariable Long id) {
		boolean eliminado = PostService.eliminarPost(id);
		if (eliminado) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Post eliminado correctamente", HttpStatus.CREATED.value(),eliminado));

		} else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No se encontró el Post con el ID proporcionado", HttpStatus.INTERNAL_SERVER_ERROR.value(),null));

		}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> modificarPost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
    	PostDTO postModificado = PostService.modificarPost(id, postDTO);
        if (postModificado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Post modificado con éxito", HttpStatus.OK.value(), postModificado));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Post no encontrado", HttpStatus.NOT_FOUND.value(), null));
        }
    }

}
