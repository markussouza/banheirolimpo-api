/**
 * 
 */
package com.inova.banheirolimpo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.inova.banheirolimpo.enums.Situacao;

import lombok.Data;

/**
 * @author Markus Souza on 03/11/2017
 *
 */

@Entity
@Data
public class ProcedimentoOperacionalPadrao implements Serializable {
	
	private static final long serialVersionUID = -7253693949356512861L;
	
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo título é de preenchimento obrigatório.")
	@Size(min = 5, max = 100)
	@Column(nullable = false, length = 100)
	private String titulo;
	
	@NotBlank(message = "O campo documento é de preenchimento obrigatório.")
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(nullable = false)
	private String documento;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;

}
