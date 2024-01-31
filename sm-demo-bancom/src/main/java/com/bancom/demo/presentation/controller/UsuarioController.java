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
import org.springframework.web.bind.annotation.RestController;

import com.bancom.demo.generic.service.UsuarioService;
import com.bancom.demo.presentation.dto.UsuarioDTO;
import com.bancom.demo.util.ApiResponse;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
    @PostMapping
    public ResponseEntity<Object> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    	UsuarioDTO nuevoUsuario = usuarioService.crearUsuario(usuarioDTO);
        if (nuevoUsuario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Usuario creado con éxito", HttpStatus.CREATED.value(),nuevoUsuario));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No se pudo crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR.value(),nuevoUsuario));
        }
    }
    
    @GetMapping
    public  ResponseEntity<Object> listarUsuarios() {
    	List<UsuarioDTO> usuarios=  usuarioService.listarUsuarios();
        if (!usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Usuario creado con éxito", HttpStatus.CREATED.value(),usuarios));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No se pudo crear el usuarios", HttpStatus.INTERNAL_SERVER_ERROR.value(),null));
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  eliminarUsuario(@PathVariable Long id) {
		boolean eliminado = usuarioService.eliminarUsuario(id);
		if (eliminado) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Usuario eliminado correctamente", HttpStatus.CREATED.value(),eliminado));

		} else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No se encontró el usuario con el ID proporcionado", HttpStatus.INTERNAL_SERVER_ERROR.value(),null));

		}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> modificarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioModificado = usuarioService.modificarUsuario(id, usuarioDTO);
        if (usuarioModificado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Usuario modificado con éxito", HttpStatus.OK.value(), usuarioModificado));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Usuario no encontrado", HttpStatus.NOT_FOUND.value(), null));
        }
    }
    
}
