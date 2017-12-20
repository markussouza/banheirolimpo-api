package com.inova.banheirolimpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inova.banheirolimpo.model.Funcao;

/**
 * @author markussouza
 *
 */

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
	
	Funcao findByDescricao(String descricao);

}
