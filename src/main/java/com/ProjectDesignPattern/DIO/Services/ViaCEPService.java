package com.ProjectDesignPattern.DIO.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ProjectDesignPattern.DIO.Model.Endereco;


@FeignClient(name="viacep",url = "https://viacep.com.br/ws")
public interface ViaCEPService {
		
	@GetMapping("/{cep}/json/")
	
	Endereco consultaCEP(@PathVariable("cep")String cep);
	
}
