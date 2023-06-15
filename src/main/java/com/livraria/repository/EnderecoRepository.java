package com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	boolean existsByCep(String cep);
	


}
