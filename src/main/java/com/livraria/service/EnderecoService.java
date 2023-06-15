package com.livraria.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.livraria.exception.NegocioException;
import com.livraria.exception.TabelaDeErros;
import com.livraria.model.Endereco;
import com.livraria.model.dto.EnderecoEntradaDto;
import com.livraria.model.dto.EnderecoSaidaDto;
import com.livraria.repository.EnderecoRepository;
import com.livraria.validator.EnderecoValidator;


@Service

public class EnderecoService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private EnderecoValidator validator;

	public EnderecoSaidaDto criarEndereco(EnderecoEntradaDto entrada) {
		validator.validarEndereco(entrada);
		Endereco endereco = mapper.map(entrada, Endereco.class);
		Endereco entityBanco = repository.save(endereco);
		
		return mapper.map(entityBanco, EnderecoSaidaDto.class);

	}

	public EnderecoSaidaDto pegarUmEndereco(Long id) {
		try {
			Optional<Endereco> buscandoEndereco = repository.findById(id);
			Endereco entityBanco = buscandoEndereco.get();
			return mapper.map(entityBanco, EnderecoSaidaDto.class);
		}catch(NoSuchElementException e) {
			throw new NegocioException(TabelaDeErros.ENDERECO_NAO_ENCONTRADO);
		}
	}

	public void excluirEndereco(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new NegocioException(TabelaDeErros.ENDERECO_NAO_ENCONTRADO);
		}catch(DataIntegrityViolationException e) {
			throw new NegocioException(TabelaDeErros.ENDERECO_CINCULADO_A_CLIENTE);
		}

	}

	public List<EnderecoSaidaDto> listarEnderecos() {
		List<Endereco> listaEndereco = repository.findAll();
		return mapper.map(listaEndereco, new TypeToken<List<EnderecoSaidaDto>>() {
		}.getType());
	}

}
