/**
 * 
 */
package com.inova.banheirolimpo.telegram.model;

import java.util.List;

import lombok.Data;

/**
 * @author Markus Souza on 19/12/2017
 */
@Data
public class Message {

	private int message_id;
	private From from;
	private Chat chat;
	private int date;
	private String text;
	private List<Entity> entities;

}
