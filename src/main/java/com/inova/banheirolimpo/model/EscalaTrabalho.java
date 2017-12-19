/**
 * 
 */
package com.inova.banheirolimpo.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

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
public class EscalaTrabalho extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 3741769976893602961L;
	
	@NotBlank(message = "A descrição é de preenchimento obrigatório.")
	@Size(min = 3, max = 15, message = "A descrição deve conter no mínimo {min} caracteres.")
	@Getter @Setter
	private String descricao;

}
