package com.livraria.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livraria.exception.NegocioException;
import com.livraria.exception.TabelaDeErros;
import com.livraria.model.dto.ClienteEntradaDto;
import com.livraria.repository.ClienteRepository;

@Component
public class ClienteValidator {
	
//	@Autowired
//	private ClienteRepository clienteRepository;
//	
//	public void validarCpf(ClienteEntradaDto entrada) {
//		if(clienteRepository.existsByCpf(entrada.getCpf())) {
//			throw new NegocioException(TabelaDeErros.CPF_JA_CADASTRADO);
//		}
//	}
	
	

}
