package com.inova.banheirolimpo.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.inova.banheirolimpo.model.Papel;
import com.inova.banheirolimpo.model.Usuario;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um usuário.
	 * 
	 * @param usuario
	 * @return JwtUser
	 */
	public static JwtUser create(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getLogin(), usuario.getSenha(),
				mapToGrantedAuthorities(usuario.getPapeis()));
	}

	/**
	 * Converte o papel do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param papel
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Papel> papeis) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Papel papel : papeis) {
			authorities.add(new SimpleGrantedAuthority(papel.getNome()));
		}
		
		return authorities;
	}

}
