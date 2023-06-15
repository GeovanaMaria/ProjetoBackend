package com.livraria.service;

import java.time.LocalDate;
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
import com.livraria.model.Cliente;
import com.livraria.model.Endereco;
import com.livraria.model.Telefone;
import com.livraria.model.dto.ClienteAlterarDto;
import com.livraria.model.dto.ClienteEntradaDto;
import com.livraria.model.dto.ClienteSaidaDto;
import com.livraria.repository.ClienteRepository;
import com.livraria.repository.EnderecoRepository;
import com.livraria.repository.TelefoneRepository;
import com.livraria.validator.ClienteValidator;


@Service
public class ClienteService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

//	@Autowired
//	private ClienteValidator validator;

	public ClienteSaidaDto criarCliente(ClienteEntradaDto entrada) {
//		validator.validarCpf(entrada);
		Cliente entity = mapper.map(entrada, Cliente.class);
//		if (entrada.getDataDeCadastro() == null) {
//			entity.setDataDeCadastro(LocalDate.now());
//		}
//
//		List<Long> idsTelefones = entrada.getIdTelefones();
//		List<Telefone> telefones = telefoneRepository.findAllById(idsTelefones);
//
//		if (!telefones.isEmpty()) {
//			entity.setTelefone(telefones);
//		} else {
//			throw new NegocioException(TabelaDeErros.TELEFONE_NAO_ENCONTRADO);
//		}
//
//		Optional<Endereco> buscandoEndereco = enderecoRepository.findById(entrada.getIdEndereco());
//		if (buscandoEndereco.isPresent()) {
//			Endereco endereco = buscandoEndereco.get();
//			entity.setEndereco(endereco);
//		} else {
//			throw new NegocioException(TabelaDeErros.ENDERECO_NAO_ENCONTRADO);
//		}

		Cliente entityBanco = clienteRepository.save(entity);

		return mapper.map(entityBanco, ClienteSaidaDto.class);
	}

	public void alterarCliente(Long id, ClienteAlterarDto alterar) {
		try {
			Optional<Cliente> buscandoCliente = clienteRepository.findById(id);
			Cliente entityBanco = buscandoCliente.get();
			mapper.map(alterar, entityBanco);

//			List<Long> idsTelefones = alterar.getIdTelefones();
//			List<Telefone> telefones = telefoneRepository.findAllById(idsTelefones);
//
//			if (!telefones.isEmpty()) {
//				entityBanco.setTelefone(telefones);
//			} else {
//				throw new NegocioException(TabelaDeErros.TELEFONE_NAO_ENCONTRADO);
//			}
//
//			Optional<Endereco> buscandoEndereco = enderecoRepository.findById(alterar.getIdEndereco());
//			if (buscandoEndereco.isPresent()) {
//				Endereco endereco = buscandoEndereco.get();
//				entityBanco.setEndereco(endereco);
//			} else {
//				throw new NegocioException(TabelaDeErros.ENDERECO_NAO_ENCONTRADO);
//			}

			clienteRepository.save(entityBanco);

		} catch (NoSuchElementException e) {
			throw new NegocioException(TabelaDeErros.CLIENTE_NAO_ENCONTRADO);
		}

	}

	public ClienteSaidaDto pegarUmCliente(Long id) {
		try {
			Optional<Cliente> buscandoCliente = clienteRepository.findById(id);

			Cliente entityBanco = buscandoCliente.get();
			return mapper.map(entityBanco, ClienteSaidaDto.class);
			
		} catch (NoSuchElementException e) {
			throw new NegocioException(TabelaDeErros.CLIENTE_NAO_ENCONTRADO);
		}
	}

	public void excluirCliente(Long id) {
		try {
			clienteRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new NegocioException(TabelaDeErros.CLIENTE_NAO_ENCONTRADO);

		}
	}

	public List<ClienteSaidaDto> listarCliente() {
		List<Cliente> listaClientes = clienteRepository.findAll();
		return mapper.map(listaClientes, new TypeToken<List<ClienteSaidaDto>>() {
		}.getType());
	}

	public Cliente getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
