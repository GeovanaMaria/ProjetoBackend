package com.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.model.dto.EnderecoEntradaDto;
import com.livraria.model.dto.EnderecoSaidaDto;
import com.livraria.service.EnderecoService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("livraria")
@Log4j2
@Validated
public class EnderecoController {

	@Autowired
	EnderecoService service;
	

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("endereco")
	public EnderecoSaidaDto criarPedido(@Valid @RequestBody EnderecoEntradaDto entrada) {
		log.info("Recebendo uma requisição: metodo = criar, entradaDto{}", entrada);
		return service.criarEndereco(entrada);
	}

	@GetMapping("endereco/id/{id}")
	public EnderecoSaidaDto pegarUmEndereco(@PathVariable("id") Long id) {
		log.info("PegarUm: {}", id);
		return service.pegarUmEndereco(id);
	}

	@DeleteMapping("endereco/id/{id}")
	public void excluirEndereco(@PathVariable("id") Long id) {
		log.info("excluir: {}", id);
		service.excluirEndereco(id);
	}

	@GetMapping("endereco")
	public List<EnderecoSaidaDto> listarEndereco() {
		log.info("listar");
		return service.listarEnderecos();
	}

}
