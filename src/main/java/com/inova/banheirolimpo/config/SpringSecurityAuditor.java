/**
 * 
 */
package com.inova.banheirolimpo.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @author Markus Souza on 08/11/2017
 *
 */
public class SpringSecurityAuditor implements AuditorAware<String> {
	
	@Override
	public String getCurrentAuditor() {
		
		//ira retornar o usuário que está no contexto fazendo as operações
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//anonymousUser - quando o usuáro anonimo está realizando operações
		if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
			
			return authentication.getPrincipal().toString();
		}
		
		return ((User) authentication.getPrincipal()).getUsername();
	}

}
