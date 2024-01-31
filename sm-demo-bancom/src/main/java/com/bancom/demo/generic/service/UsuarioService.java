package com.bancom.demo.generic.service;

import java.util.List;
import java.util.Optional;

import com.bancom.demo.persistence.models.Usuario;
import com.bancom.demo.presentation.dto.UsuarioDTO;

public interface UsuarioService {
	
	 UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
	 List<UsuarioDTO> listarUsuarios();
	 boolean eliminarUsuario(Long id);
	 Optional<Usuario> getUsuarioById(Long id );
	 UsuarioDTO modificarUsuario(Long id, UsuarioDTO usuarioDTO);
}
