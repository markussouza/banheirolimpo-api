/**
 * 
 */
package com.inova.banheirolimpo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inova.banheirolimpo.model.Usuario;
import com.inova.banheirolimpo.repository.UsuarioRepository;


/**
 * @author markussouza
 *
 */

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario findByNomeusuario(String nomeusuario) {
		return usuarioRepository.findByNomeusuario(nomeusuario);
	}
	
	public Usuario save(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

}
