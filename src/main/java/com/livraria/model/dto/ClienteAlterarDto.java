package com.livraria.model.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteAlterarDto {

//	@ApiModelProperty(example = "Luiza de Araujo", value = "Nome do cliente", required = true)
//	@NotBlank(message = "campo obrigatório")
//	@Size(max = 200, message = "ERRO, máximo permitido é 200 caracters")
//	private String nome;
//	
//	@ApiModelProperty(example = "luiza@gmail.com", value = "Email do cliente", required = true)
//	@Email
//	@NotBlank(message = "campo obrigatório")
//	private String email;
	
	@ApiModelProperty(example = "123", value = "Senha do Cliente", required = true)
	@NotBlank(message = "campo obrigatório")
	@Size(max = 200, message = "ERRO, máximo permitido é 10 caracters")
	private String senha;

//	@ApiModelProperty(example = "1", value = "Id do Telefone do Cliente", required = true)
//	@NotNull(message = "campo obrigatório")
//	private List<Long> idTelefones;
//
//	@ApiModelProperty(example = "1", value = "Id do Endereco do Cliente", required = true)
//	@NotNull(message = "campo obrigatório")
//	private Long idEndereco;

}
