package com.livraria.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livraria.exception.NegocioException;
import com.livraria.exception.TabelaDeErros;
import com.livraria.model.dto.TelefoneEntradaDto;
import com.livraria.repository.TelefoneRepository;

@Component
public class TelefoneValidator {
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	

	public void validarNumero(TelefoneEntradaDto entrada) {
		if(telefoneRepository.existsByNumero(entrada.getNumero())) {
			throw new NegocioException(TabelaDeErros.TELEFONE_JA_CADASTRADO);
		}
	}
	

}
