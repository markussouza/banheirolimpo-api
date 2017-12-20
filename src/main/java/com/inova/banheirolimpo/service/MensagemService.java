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

import com.inova.banheirolimpo.model.Funcao;
import com.inova.banheirolimpo.model.Funcionario;
import com.inova.banheirolimpo.model.Sensor;
import com.inova.banheirolimpo.repository.FuncaoRepository;
import com.inova.banheirolimpo.repository.FuncionarioRepository;
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
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Value("${bot.token}")
	private String token;
	
	private TelegramBot bot;
	
	public Message enviarMensagem(String numeroSensor) {
		SendMessage request = null;
		Message message = null;
		bot = new TelegramBot(token);
		Optional<Sensor> sensor = sensorService.findByNumero(numeroSensor);
		if (sensor.isPresent()) {
			String msg = String.format("Limite para limpeza do banheiro %s atingido.", sensor.get().getBanheiro().getNome());
			Funcao funcao = funcaoRepository.findByDescricao("ENCARREGADO");
			Funcionario funcionario = funcionarioRepository.findByClienteAndFuncao(sensor.get().getBanheiro().getCliente(), funcao);
			
			request = new SendMessage(funcionario.getTelegramChatId(), msg)
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
	public void getUpdates() {
		bot = new TelegramBot(token);
		GetUpdates getUpdates = new GetUpdates().limit(100).offset(0).timeout(0);
		List<Update> updates = bot.execute(getUpdates).updates();
		
		if (!updates.isEmpty()) {
			Funcionario funcionario = null;
			for (Update update : updates) {
				funcionario = funcionarioRepository.findByPrimeiroNomeAndUltimoNome(update.message().chat().firstName(), update.message().chat().lastName());
				if (funcionario != null) {
					funcionario.setTelegramChatId(update.message().chat().id());
					funcionario = funcionarioService.atualizar(funcionario.getId(), funcionario);
				}
			}
		}
	}

}
