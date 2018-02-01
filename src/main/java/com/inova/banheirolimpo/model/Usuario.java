/**
 * 
 */
package com.inova.banheirolimpo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

import com.inova.banheirolimpo.enums.Situacao;

import lombok.Data;

/**
 * @author Markus Souza on 16/11/2017.
 *
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"login"}, name = "UK_LOGIN")})
@Data
public class Usuario implements Serializable {

	private static final long serialVersionUID = -21490618310254829L;
	
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O campo login é obrigatório")
	@Column(length = 9)
	private String login;

	@NotEmpty(message = "O campo senha é obrigatório")
	@Column(length = 100)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 7)
	private Situacao situacao;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_papel", 
			   joinColumns = { @JoinColumn(name = "usuario_id",  foreignKey = @ForeignKey(name = "FK_USUARIO_ID")) }, 
			   inverseJoinColumns = {@JoinColumn(name = "papel_id", foreignKey = @ForeignKey(name = "FK_PAPEL_ID")) })
	@OrderBy("nome asc")
	private Set<Papel> papeis = new HashSet<>();

}
