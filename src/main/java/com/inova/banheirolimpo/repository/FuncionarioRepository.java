package com.inova.banheirolimpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inova.banheirolimpo.model.Cliente;
import com.inova.banheirolimpo.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	List<Funcionario> findAllByEstabelecimento(Cliente estabelecimento);
	
	Funcionario findByNome(String nome);

}
