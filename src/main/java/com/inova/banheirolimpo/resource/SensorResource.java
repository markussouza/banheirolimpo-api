/**
 * 
 */
package com.inova.banheirolimpo.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inova.banheirolimpo.model.Sensor;
import com.inova.banheirolimpo.repository.SensorRepository;
import com.inova.banheirolimpo.service.SensorService;

/**
 * @author Markus Souza on 01/02/2018
 *
 */
@RestController
@RequestMapping("/api/sensores")
public class SensorResource {
	
	@Autowired
	private SensorRepository sensorRepository;
	
	@Autowired
	private SensorService sensorService;
	
	public List<Sensor> obterTodos() {
		return sensorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sensor> obterPorId(@PathVariable Long id) {
		Sensor sensor = sensorRepository.findOne(id);
		return sensor != null ? ResponseEntity.ok(sensor) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Sensor> criar(@Valid @RequestBody Sensor sensor) {
		//TenantContext.setCurrentTenant(tenantName);
		Sensor novoSensor = sensorRepository.save(sensor);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoSensor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Sensor> atualizar(@PathVariable Long id, @Valid @RequestBody Sensor sensor) {
		Sensor sensorAtualizado = sensorService.atualizar(id, sensor);
		return ResponseEntity.ok(sensorAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		sensorRepository.delete(id);
	}

}
