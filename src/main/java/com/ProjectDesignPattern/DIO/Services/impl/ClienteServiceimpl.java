package com.ProjectDesignPattern.DIO.Services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectDesignPattern.DIO.Model.Cliente;
import com.ProjectDesignPattern.DIO.Model.ClienteRepository;
import com.ProjectDesignPattern.DIO.Model.Endereco;
import com.ProjectDesignPattern.DIO.Model.EnderecoRepository;
import com.ProjectDesignPattern.DIO.Services.ClienteService;
import com.ProjectDesignPattern.DIO.Services.ViaCEPService;

@Service
public class ClienteServiceimpl implements ClienteService{
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired 
	private ViaCEPService cepService;
	
	
	
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarporId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get(); 
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCEP(cliente);
		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBancoDados = clienteRepository.findById(id);
		if(clienteBancoDados.isPresent()) {
			salvarClienteComCEP(cliente);
		}
		
	}
	
	
	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
		
	}
	
	
	
	
	private void salvarClienteComCEP(Cliente cliente) {

		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
			Endereco novoEndereco= cepService.consultaCEP(cep);
			enderecoRepository.save(novoEndereco);
			return null;
		});
		cliente.setEndereco(endereco);

		clienteRepository.save(cliente);
	}

}
