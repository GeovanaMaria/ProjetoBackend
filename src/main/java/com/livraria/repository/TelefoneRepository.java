package com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

	boolean existsByNumero(String numero);
	


}
