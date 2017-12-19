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
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.inova.banheirolimpo.enums.Situacao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Markus Souza on 16/11/2017.
 *
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"login"}, name = "UK_LOGIN")})
@ToString
@EqualsAndHashCode(callSuper = false)
public class Usuario extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -21490618310254829L;

	@NotEmpty(message = "O campo login é obrigatório")
	@Column(length = 9)
	@Getter @Setter
	private String login;

	@NotEmpty(message = "O campo senha é obrigatório")
	@Column(length = 100)
	@Getter @Setter
	private String senha;
	
	@NotEmpty(message = "O campo situação é obrigatório")
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Situacao situacao;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_papel", 
			   joinColumns = { @JoinColumn(name = "usuario_id",  foreignKey = @ForeignKey(name = "FK_USUARIO_ID")) }, 
			   inverseJoinColumns = {@JoinColumn(name = "papel_id", foreignKey = @ForeignKey(name = "FK_PAPEL_ID")) })
	@Getter @Setter
	private List<Papel> papeis = new ArrayList<>();

}
