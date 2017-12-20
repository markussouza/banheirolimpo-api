/**
 * 
 */
package com.inova.banheirolimpo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import com.inova.banheirolimpo.enums.Estados;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Markus Souza on 08/11/2017
 *
 */
@MappedSuperclass
public abstract class AbstractEmpresa implements Serializable {

	private static final long serialVersionUID = -8334204095835331718L;
	
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo razão social é de preenchimento obrigatório.")
	@Column(length = 200)
	@Getter @Setter
	private String razaoSocial;
	
	@NotBlank(message = "O campo nome é de preenchimento obrigatório.")
	@Column(length = 200)
	@Getter @Setter
	private String nomeFantasia;
	
	@NotBlank(message = "O campo CNPJ é de preenchimento obrigatório.")
	@Column(length = 18)
	@CNPJ(message = "CNPJ inválido.")
	@Getter @Setter
	private String cnpj;
	
	@NotBlank(message = "O campo endereco é de preenchimento obrigatório.")
	@Column(length = 100)
	@Getter @Setter
	private String endereco;
	
	@NotBlank(message = "O campo bairro é de preenchimento obrigatório.")
	@Column(length = 150)
	@Getter @Setter
	private String bairro;
	
	@NotBlank(message = "O campo razão social é de preenchimento obrigatório.")
	@Column(length = 70)
	@Getter @Setter
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Estados uf;
	
	@Column(length = 9)
	@Pattern(regexp = "(\\d{5})-(\\d{3})")
	@Getter @Setter
	private String cep;
	
}
