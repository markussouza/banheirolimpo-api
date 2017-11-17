/**
 * 
 */
package com.inova.banheirolimpo.resource;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.banheirolimpo.service.AndroidPushNotificationsService;


/**
 * @author Markus Souza on 25/10/2017
 *
 */
@RestController
@RequestMapping("/banheirolimpo")
public class AndroidPushNotificationResource {

	@Autowired
	private AndroidPushNotificationsService androidPushNotificationsService;

	@GetMapping("/send")
	public ResponseEntity<String> send() throws JSONException {

		JSONObject body = new JSONObject();
		body.put("to",
				"eKQe36iWd-g:APA91bGyxDne8lmr9Rf-DN6ox1NZwX805EJoj6LQndDGtEPVNBR8Jv0ms8y-eB02_KVyknQxUAFYukrYCUqw6Yq2CwnQxpUJzcqKex1X9BC0s1ntlh9FhvAxGvcu-MS1UmgOBHYJA-_C");
		body.put("priority", "high");
		body.put("soud", "default");

		JSONObject notification = new JSONObject();
		notification.put("title", "Banheiro Limpo");
		notification.put("body", "Limpar banheiro 3");

		body.put("notification", notification);

		HttpEntity<String> request = new HttpEntity<>(body.toString());

		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();

		try {
			String firebaseResponse = pushNotification.get();
			//return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
			return ResponseEntity.ok(firebaseResponse);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 

		//return new ResponseEntity<>("Erro ao realizar a notificação!", HttpStatus.BAD_REQUEST);
		return ResponseEntity.badRequest().body("Erro ao realizar a notificação!");
	}

}
