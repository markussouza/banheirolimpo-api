/**
 * 
 */
package com.inova.banheirolimpo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.banheirolimpo.service.MensagemService;

/**
 * @author Markus Souza on 12/12/2017
 *
 */
@RestController
@RequestMapping("/api/mensagem")
public class MensagemResource {
	
	@Autowired
	private MensagemService telegramService;
	
	@PostMapping("/{chatId}")
	public void enviarMensagem(@PathVariable String chatId) {
		telegramService.enviarMensagem(chatId, "Esse é um teste da inova-message-api.");
	}

}
