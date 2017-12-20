package com.inova.banheirolimpo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.constraints.NotBlank;

import com.inova.banheirolimpo.enums.Situacao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author Markus Souza on 08/11/2017
 *
 */
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Cliente extends AbstractEmpresa {
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O campo centro de custo é de preenchimento obrigatório.")
	@Getter @Setter
	private String centroDeCusto;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Situacao situacao;
	
	@NotBlank
	@Column(length = 70)
	@Getter @Setter
	private String nomeWifi;
	
}
