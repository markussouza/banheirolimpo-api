/**
 * 
 */
package com.inova.banheirolimpo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * @author Markus Souza on 16/11/2017.
 *
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"}, name = "UK_NOME_PAPEL")})
@Data
public class Papel implements Serializable {
	
	private static final long serialVersionUID = -2966156421128362346L;
	
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O campo nome é obrigatório")
	@Length(min = 5, max = 15, message = "O nome deve estar entre 5 e 15 caracteres")
	private String nome;

}
