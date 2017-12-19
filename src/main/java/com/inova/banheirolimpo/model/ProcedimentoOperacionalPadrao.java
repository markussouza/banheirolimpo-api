/**
 * 
 */
package com.inova.banheirolimpo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.inova.banheirolimpo.enums.Situacao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Markus Souza
 * @since 03/11/2017
 *
 */

@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class ProcedimentoOperacionalPadrao extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = -7253693949356512861L;
	
	
	@NotBlank(message = "O campo título é de preenchimento obrigatório.")
	@Size(min = 5, max = 100)
	@Column(nullable = false, length = 100)
	@Getter @Setter
	private String titulo;
	
	@NotBlank(message = "O campo documento é de preenchimento obrigatório.")
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(nullable = false)
	@Getter @Setter
	private String documento;
	
	@Column(nullable = false, length = 7)
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Situacao situacao;

}
