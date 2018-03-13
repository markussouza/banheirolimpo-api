package com.inova.banheirolimpo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * @author Markus Souza on 08/11/2017
 *
 */
@Entity
@Data
public class Sensor implements Serializable {
	
	private static final long serialVersionUID = -8004493121365258930L;

	@Id
	@Column(name = "banheiro_id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "banheiro"))
	private Long id;
	
	@NotBlank(message = "O campo número do sensor é de preenchimento obrigatório.")
	@Column(nullable = false, length = 10)
	private String numero;
	
	@NotBlank(message = "O campo nome da wi-fi é de preenchimento obrigatório.")
	@Column(name = "nome_wifi", nullable = false, length = 70)
	private String nomeWifi;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Banheiro banheiro;

}
