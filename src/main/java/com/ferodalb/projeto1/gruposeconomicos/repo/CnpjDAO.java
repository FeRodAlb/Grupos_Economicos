package com.ferodalb.projeto1.gruposeconomicos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferodalb.projeto1.gruposeconomicos.entities.Cnpj;

public interface CnpjDAO extends JpaRepository<Cnpj, Integer> {

	Cnpj findByCnpj(String cnpj);
	
}
