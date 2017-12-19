package com.inova.banheirolimpo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.inova.banheirolimpo.enums.Situacao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Funcionario extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 1L;
	
	
	@NotBlank(message = "O campo nome é de preenchimento obrigatório.")
	@Size(min = 5, max = 150)
	@Column(nullable = false, length = 150)
	@Getter @Setter
	private String nome;
	
	@NotBlank(message = "O campo matrícula é de preenchimento obrigatório.")
	@Size(min = 3, max = 8)
	@Column(nullable = false, length = 8)
	@Getter @Setter
	private String matricula;
	
	@ManyToOne
	@JoinColumn(name = "funcao_id", foreignKey = @ForeignKey(name = "FK_FUNCAO"))
	@Getter @Setter
	private Funcao funcao;
	
	@NotBlank(message = "O campo situação é de preenchimento obrigatório")
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Situacao situacao;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_CLIENTE"))
	@Getter @Setter
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "escalaTrabalho_id", foreignKey = @ForeignKey(name = "FK_ESCALATRABALHO"))
	@Getter @Setter
	private EscalaTrabalho escalaTrabalho;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	@Cascade({CascadeType.SAVE_UPDATE})
	@Getter @Setter
	private Set<FuncionarioTarefa> funcionarioTarefas = new HashSet<>(0);
	
}
