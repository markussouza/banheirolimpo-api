/**
 * 
 */
package com.inova.banheirolimpo.telegram.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.banheirolimpo.telegram.message.service.SendMessage;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoResource {
	
	@Autowired
	private SendMessage sendMenssage;
	
	@PostMapping
	public void enviar() {
		sendMenssage.enviarMensagem();
	}

}
