package com.inova.banheirolimpo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Markus Souza on 08/11/2017
 *
 */
@Entity
@Table(name = "Funcionario_Tarefa")
@ToString
@EqualsAndHashCode(callSuper = false)
public class FuncionarioTarefa extends AbstractPersistable<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "funcionario_id", foreignKey = @ForeignKey(name = "FK_FUNCIONARIO"))
	@Getter @Setter
	private Funcionario funcionario;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "tarefa_id", foreignKey = @ForeignKey(name = "FK_TAREFA"))
	@Getter @Setter
	private Tarefa tarefa;
	
	@Column(name = "inicio_tarefa")
	@Getter @Setter
	private LocalDate inicioTarefa;
	
	@Column(name = "termino_tarefa")
	@Getter @Setter
	private LocalDate terminoTarefa;

}
