package com.inova.banheirolimpo.repository;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inova.banheirolimpo.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void testBuscarCliente() {
		Cliente cliente = clienteRepository.findOne(1L);
		assertNull(cliente);
	}

}
