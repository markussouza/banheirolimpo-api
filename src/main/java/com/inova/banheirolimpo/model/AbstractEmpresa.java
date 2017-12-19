/**
 * 
 */
package com.inova.banheirolimpo.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public abstract class AbstractEmpresa extends AbstractAuditoria<Long> {

	
	private static final long serialVersionUID = -8334204095835331718L;

	@NotBlank(message = "O campo razão social é de preenchimento obrigatório.")
	@Size(min = 5, max = 200, message = "")
	@Getter @Setter
	private String razaoSocial;
	
	@NotBlank(message = "O campo nome é de preenchimento obrigatório.")
	@Size(max = 200)
	@Getter @Setter
	private String nomeFantasia;
	
	@NotBlank(message = "O campo CNPJ é de preenchimento obrigatório.")
	@Column(nullable = false, length = 18)
	@CNPJ(message = "CNPJ inválido.")
	@Getter @Setter
	private String cnpj;
	
	@NotBlank(message = "O campo endereco é de preenchimento obrigatório.")
	@Size(min = 10, max = 100)
	@Getter @Setter
	private String endereco;
	
	@NotBlank(message = "O campo bairro é de preenchimento obrigatório.")
	@Size(min = 5, max = 150)
	@Getter @Setter
	private String bairro;
	
	@NotBlank(message = "O campo razão social é de preenchimento obrigatório.")
	@Size(max = 70)
	@Getter @Setter
	private String cidade;
	
	@NotBlank(message = "O campo uf é de preenchimento obrigatório.")
	@Size(min = 2, max = 2)
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private Estados uf;
	
	@Size(max = 9)
	@Pattern(regexp = "(\\d{5})-(\\d{3})")
	@Getter @Setter
	private String cep;
	
}
