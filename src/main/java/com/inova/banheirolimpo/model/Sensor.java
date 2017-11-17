package com.inova.banheirolimpo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Sensor extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@JoinColumn(name = "banheiro_id")
	private Long id;
	
	@NotBlank(message = "O campo número do sensor é de preenchimento obrigatório.")
	@Length(min = 5, max = 10)
	@Column(nullable = false, length = 10)
	@Getter @Setter
	private String numeroSensor;
	
	@NotBlank(message = "O campo nome da wi-fi é de preenchimento obrigatório.")
	@Length(min = 5, max = 70)
	@Column(nullable = false, length = 70)
	@Getter @Setter
	private String nomeWifi;

}
