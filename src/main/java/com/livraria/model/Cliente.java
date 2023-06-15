package com.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 200)
	private String nome;


	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 100)
	private String senha;


	@Column(nullable = true, unique = true, length = 14)
	private String cpf;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_telefone")
//	private List<Telefone> telefone;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_endereco")
//	private Endereco endereco;
//
//	@Column(name = "data_cadastro")
//	private LocalDate dataDeCadastro;

}
