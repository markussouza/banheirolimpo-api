/**
 * 
 */
package com.inova.banheirolimpo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Markus Souza
 * @since 03/11/2017
 *
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditoria<PK extends Serializable> extends AbstractPersistable<PK> {

	private static final long serialVersionUID = -3825632828445316995L;

	@Getter @Setter
	@CreatedBy
	private String criadoPor;
	
	@Getter @Setter
	@CreatedDate
	private LocalDateTime dataCriacao;
	
	@Getter @Setter
	@LastModifiedBy
	private String ultimaAlteracaoPor;
	
	@Getter @Setter
	@LastModifiedDate
	private LocalDateTime dataUltimaAlteracao;
	
	@Override
	public void setId(PK id) {
		super.setId(id);
	}
}
