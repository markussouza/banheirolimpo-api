package com.inova.banheirolimpo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.inova.banheirolimpo.model.Funcionario;
import com.inova.banheirolimpo.model.Papel;
import com.inova.banheirolimpo.model.Usuario;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionário.
	 * 
	 * @param funcionario
	 * @return JwtUser
	 */
	public static JwtUser create(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getLogin(), usuario.getSenha(),
				mapToGrantedAuthorities(usuario.getPapeis()));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Papel> papeis) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Papel papel : papeis) {
			authorities.add(new SimpleGrantedAuthority(papel.getNome()));
		}
		
		return authorities;
	}

}
