/**
 * 
 */
package com.inova.banheirolimpo.telegram.message.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inova.banheirolimpo.model.Banheiro;
import com.inova.banheirolimpo.model.Funcao;
import com.inova.banheirolimpo.model.Funcionario;
import com.inova.banheirolimpo.repository.FuncaoRepository;
import com.inova.banheirolimpo.repository.FuncionarioRepository;
import com.inova.banheirolimpo.service.BanheiroService;
import com.inova.banheirolimpo.telegram.message.model.Message;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@Service
public class SendMessage {
	
	private static final Logger log = LoggerFactory.getLogger(SendMessage.class);
	
	@Autowired
	private BanheiroService banheiroService;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${bot.token}")
	private String token;
	
	@Value("${bot.uri}")
	private String uri;
	
	
	public void enviarMensagem(String codigoSensor) {
		
		String datetime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString();
		String hora = datetime.substring(11, 16);
		
		Message message = null;
		Banheiro banheiro = banheiroService.findByCodigoSensor(codigoSensor);
		//462491517
		//350976028
		//String chat_id = "462491517";
		if (banheiro != null) {
			String msg = String.format("Limite para limpeza do banheiro %s atingido às %s", banheiro.getNome(), hora);
			Funcao funcao = funcaoRepository.findByDescricaoIgnoreCase("ENCARREGADO");
			Funcionario funcionario = funcionarioRepository.findByClienteAndFuncao(banheiro.getCliente(), funcao);
			if (funcionario != null) {
				String endpoint = String.format("%sbot%s/sendMessage?chat_id=%s&text=%s", uri, token, funcionario.getTelegramChatId(), msg);
				message = restTemplate.postForObject(endpoint, null, Message.class);
			}
		}
		
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
