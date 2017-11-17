/**
 * 
 */
package com.inova.banheirolimpo.repository;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.stereotype.Repository;

import com.inova.banheirolimpo.model.Papel;

/**
 * @author markussouza
 *
 */

@Repository
public interface PapelRepository extends JpaPersistentEntity<Long> {
	
	Papel findByNome(String nome);

}
