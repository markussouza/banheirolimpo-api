/**
 * 
 */
package com.inova.banheirolimpo.repository;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;

import com.inova.banheirolimpo.model.Papel;

/**
 * @author markussouza
 *
 */
public interface PapelRepository extends JpaPersistentEntity<Long> {
	
	Papel findByNome(String nome);

}
