/**
 * 
 */
package com.inova.banheirolimpo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.banheirolimpo.model.Sensor;
import com.inova.banheirolimpo.repository.SensorRepository;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@Service
public class SensorService {
	
	@Autowired
	private SensorRepository sensorRepository;
	
	public Optional<Sensor> findByNumero(String numero) {
		return Optional.ofNullable(sensorRepository.findByNumero(numero));
	}

}
