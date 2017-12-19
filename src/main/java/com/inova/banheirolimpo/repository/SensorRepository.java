/**
 * 
 */
package com.inova.banheirolimpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inova.banheirolimpo.model.Sensor;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
	
	Sensor findByNumero(String numero);

}
