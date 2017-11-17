/**
 * 
 */
package com.inova.banheirolimpo.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Markus Souza
 * @since 08/11/2017
 *
 */

@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Empresa extends AbstractEmpresa {
	
	private static final long serialVersionUID = 1071168608696477420L;
	
	
	@ManyToOne
	@JoinColumn(name = "empresa_pai_id", foreignKey = @ForeignKey(name = "FK_EMPRESA_PAI"))
	@Getter @Setter
	public Empresa filial;

}
