package com.inova.banheirolimpo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Tarefa extends AbstractPersistable<Long>{

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O campo nome é de preenchimento obrigatório.")
	@Column(nullable = false, length = 70)
	@Getter @Setter
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarefa")
	@Cascade({CascadeType.SAVE_UPDATE})
	@Getter @Setter
	private Set<FuncionarioTarefa> funcionarioTarefas = new HashSet<>();
	
}
