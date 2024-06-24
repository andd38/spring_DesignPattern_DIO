package com.ProjectDesignPattern.DIO.Services;

import com.ProjectDesignPattern.DIO.Model.Cliente;

public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarporId(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Long id,Cliente cliente);
	
	void deletar(Long id);
	
}
