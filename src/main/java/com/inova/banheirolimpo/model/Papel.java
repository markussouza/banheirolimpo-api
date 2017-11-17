/**
 * 
 */
package com.inova.banheirolimpo.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Markus Souza on 16/11/2017.
 *
 */
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Papel extends AbstractAuditoria<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2966156421128362346L;

	@NotEmpty(message = "O campo sigla é obrigatório")
	@Length(min = 5, max = 15, message = "A sigla deve estar entre 5 e 15 caracteres")
	@Getter @Setter
	private String sigla;
	
	@NotEmpty(message = "O campo descrição é obrigatório")
	@Length(min = 5, max = 15, message = "A sigla deve estar entre 5 e 15 caracteres")
	@Getter @Setter
	private String descricao;

}
