/**
 * 
 */
package com.inova.banheirolimpo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.inova.banheirolimpo.enums.Situacao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Markus Souza on 25/10/2017
 *
 */
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Funcao extends AbstractPersistable<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O campo descrição é de preenchimento obrigatório.")
	@Length(min = 5, max = 20, message = "O campo descrição deve conter entre 5 e 20 caracteres.")
	@Column(nullable = false, length = 20)
	@Getter @Setter
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	@Getter @Setter
	private Situacao situacao;
	
}
