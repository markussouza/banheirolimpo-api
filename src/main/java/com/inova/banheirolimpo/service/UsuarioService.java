/**
 * 
 */
package com.inova.banheirolimpo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inova.banheirolimpo.model.Usuario;
import com.inova.banheirolimpo.repository.UsuarioRepository;


/**
 * @author Markus Souza on 18/12/2017
 *
 */

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Optional<Usuario> findByLogin(String login) {
		return Optional.ofNullable(usuarioRepository.findByLogin(login)) ;
	}
	
	public Usuario save(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

}
