package com.bancom.demo.generic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancom.demo.mapper.UsuarioMapper;
import com.bancom.demo.persistence.models.Usuario;
import com.bancom.demo.persistence.repository.UsuarioRepository;
import com.bancom.demo.presentation.dto.UsuarioDTO;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    
	@Override
	public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
		
        Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.toDto(usuario);
	}
	
    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioMapper.INSTANCE.toDtoList(usuarios);
    }

	@Override
	public boolean eliminarUsuario(Long id) {
		
		Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioRepository.delete(usuarioExistente);
            return true;
        } else {
            return false;
        }
	}

	@Override
	public UsuarioDTO modificarUsuario(Long id, UsuarioDTO usuarioDTO) {
	      Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
	        if (usuarioExistente != null) {
	            usuarioExistente.setCellphone(usuarioDTO.getCellphone());
	            usuarioExistente.setName(usuarioDTO.getName());
	            usuarioExistente.setLastName(usuarioDTO.getLastName());
	            usuarioExistente.setPassword(usuarioDTO.getPassword());
	            Usuario usuarioModificado = usuarioRepository.save(usuarioExistente);
	            return UsuarioMapper.INSTANCE.toDto(usuarioModificado);
	        } else {
	            return null;
	        }
	}

	@Override
	public Optional<Usuario> getUsuarioById(Long id) {
		return usuarioRepository.findById(id);
	}
	
}
