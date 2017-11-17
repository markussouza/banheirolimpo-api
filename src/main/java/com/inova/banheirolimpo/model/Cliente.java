package com.inova.banheirolimpo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Cliente extends AbstractEmpresa {
	
	private static final long serialVersionUID = 1L;

	
	@NotBlank(message = "O campo centro de custo é de preenchimento obrigatório.")
	@Getter @Setter
	private String centroDeCusto;
	
	@NotBlank(message = "O campo situação é de preencimento obrigatório.")
	@Size(min = 1, max = 7)
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Situacao situacao;
	
	@NotBlank
	@Size(min = 5, max = 70)
	@Getter @Setter
	private String nomeWifi;
	
}
