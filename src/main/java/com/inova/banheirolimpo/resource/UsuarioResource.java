/**
 * 
 */
package com.inova.banheirolimpo.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.banheirolimpo.model.Usuario;
import com.inova.banheirolimpo.service.UsuarioService;

/**
 * @author Markus Souza on 19/12/2017
 *
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{login}")
	public ResponseEntity<Usuario> obterPorLogin(@PathVariable String login) {
		Optional<Usuario> usuario = usuarioService.findByLogin(login.trim());
		Usuario usr = usuario.get();
		return usuario.isPresent() ? ResponseEntity.ok(usr) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}

}
