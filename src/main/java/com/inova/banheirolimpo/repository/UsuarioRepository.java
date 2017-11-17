/**
 * 
 */
package com.inova.banheirolimpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inova.banheirolimpo.model.Usuario;

/**
 * @author markussouza
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByNomeusuario(String usuario);

}
