/**
 * 
 */
package com.inova.banheirolimpo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
public class Usuario extends AbstractAuditoria<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -21490618310254829L;

	@NotEmpty(message = "O campo usuário é obrigatório")
	@Length(min = 5, max = 5, message = "O nome do usuário deve conter 5 caracteres")
	@Column(unique = true)
	@Getter @Setter
	private String nomeusuario;

	@NotEmpty(message = "O campo senha é obrigatório")
	@Length(min = 6, max = 8, message = "A senha deve conter entre 6 e 8 caracteres")
	@Getter @Setter
	private String senha;
	
	@NotEmpty(message = "O campo situação é obrigatório")
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Situacao situacao;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_papel", 
			   joinColumns = { @JoinColumn(name = "usuario_id") }, 
			   inverseJoinColumns = {@JoinColumn(name = "papel_id") })
	@Getter @Setter
	private List<Papel> papeis = new ArrayList<>();

}
