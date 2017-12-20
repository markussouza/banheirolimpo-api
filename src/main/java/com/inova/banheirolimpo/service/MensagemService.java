/**
 * 
 */
package com.inova.banheirolimpo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.inova.banheirolimpo.model.Sensor;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * @author Markus Souza on 12/12/2017
 *
 */
@Service
public class MensagemService {
	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	@Autowired
	private SensorService sensorService;
	
	@Value("${bot.token}")
	private String token;
	
	private TelegramBot bot;
	
	public Message enviarMensagem(String numeroSensor) {
		SendMessage request = null;
		Message message = null;
		bot = new TelegramBot(token);
		Optional<Sensor> sensor = sensorService.findByNumero(numeroSensor);
		if (sensor.isPresent()) {
			String msg = String.format("Limite para limpeza do banheiro %s atingido.", sensor.get().getBanheiro().getId());
			
			request = new SendMessage("350976028", msg)
			        .parseMode(ParseMode.HTML)
			        .disableWebPagePreview(true)
			        .disableNotification(true)
			        .replyToMessageId(1)
			        .replyMarkup(new ForceReply());
			message = bot.execute(request).message();
		}

		return message;

	}
	
	@Scheduled(cron = "* */5 * * * *", zone = TIME_ZONE)
	public List<Update> getUpdates() {
		bot = new TelegramBot(token);
		GetUpdates getUpdates = new GetUpdates()
				.limit(100)
				.offset(0)
				.timeout(0);
		List<Update> updates = bot.execute(getUpdates).updates();
		return updates;
	}

}
