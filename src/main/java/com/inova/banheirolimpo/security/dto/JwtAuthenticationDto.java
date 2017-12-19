package com.inova.banheirolimpo.security.dto;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class JwtAuthenticationDto {
	
	@NotEmpty(message = "Login não pode ser vazio.")
	private String Login;
	
	@NotEmpty(message = "Senha não pode ser vazia.")
	private String senha;

}
