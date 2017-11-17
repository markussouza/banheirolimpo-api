package com.inova.banheirolimpo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
public class Banheiro extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = -3505657055346485475L;
	
	@NotBlank(message = "O campo nome é de preenchimento obrigatório.")
	@Length(min = 10, max = 100, message = "O nome deve ter entre 10 e 100 caracteres.")
	@Column(nullable = false, length = 100)
	@Getter @Setter
	private String nome;
	
	@NotBlank(message = "O campo localização é de preenchimento obrigatório.")
	@Length(min = 5, max = 70, message = "O nome deve ter entre 5 e 70 caracteres.")
	@Column(nullable = false, length = 70)
	@Getter @Setter
	private String localizacao;
	
	@NotBlank(message = "O campo quantodade de boxes é de preenchimento obrigatório.")
	@Column(name = "quantidade_boxes", nullable = false)
	@Getter @Setter
	private Integer quantidadeBoxes;
	
	@NotBlank(message = "O campo limitador de limpeza é de preenchimento obrigatório.")
	@Column(name = "limitador_limpeza", nullable = false)
	@Getter @Setter
	private Integer limitadorLimpeza;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Getter @Setter
	private Sensor sensor;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_CLIENTE"))
	@Getter @Setter
	private Cliente cliente;

}
