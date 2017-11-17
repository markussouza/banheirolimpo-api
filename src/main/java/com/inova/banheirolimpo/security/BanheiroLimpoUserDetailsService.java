/**
 * 
 */
package com.inova.banheirolimpo.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.inova.banheirolimpo.model.Papel;
import com.inova.banheirolimpo.model.Usuario;
import com.inova.banheirolimpo.repository.UsuarioRepository;

/**
 * @author Markus Souza on 16/11/2017
 *
 */
public class BanheiroLimpoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String nomeusuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNomeusuario(nomeusuario);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return new User(usuario.getNomeusuario(), usuario.getSenha(), authorities(usuario));
	}
	
	public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		Collection<GrantedAuthority> auths = new ArrayList<>();
		
		for (Papel papel: usuario.getPapeis()) {
			auths.add(new SimpleGrantedAuthority("ROLE_" + papel.getSigla()));
		}
		
		return auths;
	}

}
