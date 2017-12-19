/**
 * 
 */
package com.inova.banheirolimpo.telegram.message.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inova.banheirolimpo.model.Sensor;
import com.inova.banheirolimpo.service.SensorService;
import com.inova.banheirolimpo.telegram.message.model.Message;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@Service
public class SendMessage {
	
	@Autowired
	private SensorService sensorService;
	
	@Value("${bot.token}")
	private String token;
	
	@Value("${bot.uri}")
	private String uri;
	
	private RestTemplate restTemplate;
	
	
	public void enviarMensagem(String numeroSensor) {
		//https://api.telegram.org/bot488451384:AAFWSI6-SyR02hZ-hpXQRYtlE0bsQP4CbPU/sendMessage?chat_id=350976028&text=Oi...
		Optional<Sensor> sensor = sensorService.findByNumero(numeroSensor);
		if (sensor.isPresent()) {
			restTemplate = new RestTemplate();
			String msg = String.format("Limite para limpeza do banheiro %s atingido.", sensor.get().getBanheiro().getId());
			
			String endpoint = String.format("%sbot%s/sendMessage?chat_id=%s&text=%s", uri, token, "", msg);
			Message message = restTemplate.postForObject(endpoint, null, Message.class);
		}

	}
	
	public void enviarMensagem() {
		restTemplate = new RestTemplate();
		String msg = String.format("Limite para limpeza do banheiro %s atingido.", "F2P");
		
		String endpoint = String.format("%sbot%s/sendMessage?chat_id=%s&text=%s", uri, token, "350976028", msg);
		Message message = restTemplate.postForObject(endpoint, null, Message.class);
	}

}
