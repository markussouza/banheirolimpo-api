/**
 * 
 */
package com.inova.banheirolimpo.telegram.model;

import lombok.Data;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@Data
public class From {

	private int id;
	private boolean is_bot;
	private String first_name;
	private String username;

}
