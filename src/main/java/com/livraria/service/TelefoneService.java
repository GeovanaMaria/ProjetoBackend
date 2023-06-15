package com.livraria.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.livraria.exception.NegocioException;
import com.livraria.exception.TabelaDeErros;
import com.livraria.model.Telefone;
import com.livraria.model.dto.TelefoneEntradaDto;
import com.livraria.model.dto.TelefoneSaidaDto;
import com.livraria.repository.TelefoneRepository;
import com.livraria.validator.TelefoneValidator;


@Service

public class TelefoneService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private TelefoneRepository repository;
	
	@Autowired
	private TelefoneValidator validator;

	public TelefoneSaidaDto criarTelefone(TelefoneEntradaDto entrada) {
		validator.validarNumero(entrada);
		Telefone telefone = mapper.map(entrada, Telefone.class);
		Telefone entityBanco = repository.save(telefone);

		return mapper.map(entityBanco, TelefoneSaidaDto.class);

	}

	public TelefoneSaidaDto pegarUmEndereco(Long id) {
		try {
			Optional<Telefone> buscandoTelefone = repository.findById(id);
			Telefone entityBanco = buscandoTelefone.get();
			return mapper.map(entityBanco, TelefoneSaidaDto.class);
		}catch(NoSuchElementException e) {
			throw new NegocioException(TabelaDeErros.TELEFONE_NAO_ENCONTRADO);
		}
	

	}

	public void excluirEndereco(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new NegocioException(TabelaDeErros.TELEFONE_NAO_ENCONTRADO);
		}
			
	}

	public List<TelefoneSaidaDto> listarTelefones() {
		List<Telefone> listaTelefones = repository.findAll();
		return mapper.map(listaTelefones, new TypeToken<List<TelefoneSaidaDto>>() {
		}.getType());
	}

}
