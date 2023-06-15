package com.livraria.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livraria.exception.NegocioException;
import com.livraria.exception.TabelaDeErros;
import com.livraria.model.dto.EnderecoEntradaDto;
import com.livraria.repository.EnderecoRepository;

@Component
public class EnderecoValidator {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public void validarEndereco(EnderecoEntradaDto entrada) {
		if(enderecoRepository.existsByCep(entrada.getCep())) {
			throw new NegocioException(TabelaDeErros.ENDERECO_JA_CADASTRADO);
		}
	}
	

}
