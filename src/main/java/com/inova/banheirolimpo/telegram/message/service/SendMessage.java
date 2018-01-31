/**
 * 
 */
package com.inova.banheirolimpo.telegram.message.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inova.banheirolimpo.model.Funcao;
import com.inova.banheirolimpo.model.Funcionario;
import com.inova.banheirolimpo.model.Sensor;
import com.inova.banheirolimpo.repository.FuncaoRepository;
import com.inova.banheirolimpo.repository.FuncionarioRepository;
import com.inova.banheirolimpo.service.SensorService;
import com.inova.banheirolimpo.telegram.message.model.Message;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@Service
public class SendMessage {
	
	private static final Logger log = LoggerFactory.getLogger(SendMessage.class);
	
	@Autowired
	private SensorService sensorService;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Value("${bot.token}")
	private String token;
	
	@Value("${bot.uri}")
	private String uri;
	
	private RestTemplate restTemplate;
	
	
	public void enviarMensagem(String numeroSensor) {
		
		String datetime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString();
		String hora = datetime.substring(11, 16);
		
		Message message = null;
		Optional<Sensor> sensor = sensorService.findByNumero(numeroSensor);
		//462491517
		//350976028
		String chat_id = "462491517";
		//if (sensor.isPresent()) {
			restTemplate = new RestTemplate();
			String msg = String.format("Limite para limpeza do banheiro %s atingido às %s", "F2P", hora);
			//String msg = String.format("Limite para limpeza do banheiro %s atingido.", sensor.get().getBanheiro().getNome());
			//Funcao funcao = funcaoRepository.findByDescricao("ENCARREGADO");
			//Funcionario funcionario = funcionarioRepository.findByClienteAndFuncao(sensor.get().getBanheiro().getCliente(), funcao);
			//if (funcionario != null) {
				String endpoint = String.format("%sbot%s/sendMessage?chat_id=%s&text=%s", uri, token, chat_id, msg);
				message = restTemplate.postForObject(endpoint, null, Message.class);
			//}
		//}
		
		log.info(message.toString());

	}
	
	/*public void enviarMensagem() {
		SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy-rr.redecamara.camara.gov.br", 80));
		clientHttpReq.setProxy(proxy);
		restTemplate = new RestTemplate(clientHttpReq);
		String msg = String.format("Limite para limpeza do banheiro %s atingido.", "F2P");
		
		String endpoint = String.format("%sbot%s/sendMessage?chat_id=%s&text=%s", uri, token, "350976028", msg);
		Message message = restTemplate.postForObject(endpoint, null, Message.class);
	}*/

}
