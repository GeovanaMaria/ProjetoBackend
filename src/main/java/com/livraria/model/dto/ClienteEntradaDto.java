package com.livraria.model.dto;


import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteEntradaDto {
	
	@ApiModelProperty(example = "Luiza de Araujo", value = "Nome do cliente", required = true)
	@NotBlank(message = "campo obrigatório")
	@Size( max=200, message="ERRO, máximo permitido é 200 caracters")
	private String nome;
	
//	@ApiModelProperty(example = "000.000.000-00", value = "Cpf do cliente", required = true)
//	@NotBlank(message = "campo obrigatório")
//	@Size( max=14, message="ERRO, cpf inválido")
//	private String cpf;
	
	@ApiModelProperty(example = "luiza@gmail.com", value = "Email do cliente", required = true)
	@Email
	@NotBlank(message = "campo obrigatório")
	@Size( max=100, message="ERRO, email inválido")
	private String email;

	@ApiModelProperty(example = "123", value = "Senha do Cliente", required = true)
	@NotBlank(message = "campo obrigatório")
	@Size( max=100, message="ERRO, máximo permitido é 10 caracters")
	private String senha;
	
//	@ApiModelProperty(example = "1", value = "Id do Telefone do Cliente", required = true)
//	@NotNull(message = "campo obrigatório")
//	private List<Long> idTelefones;
//	
//	@ApiModelProperty(example = "1", value = "Id do Endereco do Cliente", required = true)
//	@NotNull(message = "campo obrigatório")
//	private Long idEndereco;
//	
//	@ApiModelProperty(example = "20/05/2023", value = "Data de Cadastro", required = true)
//	@JsonFormat(pattern = "dd/MM/yyyy")
//	private LocalDate dataDeCadastro;

	
	

}
