package com.ferodalb.projeto1.gruposeconomicos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferodalb.projeto1.gruposeconomicos.entities.Cnpj;
import com.ferodalb.projeto1.gruposeconomicos.entities.GrupoEconomico;

public interface GrupoDAO extends JpaRepository<GrupoEconomico, Integer> {

	GrupoEconomico findByCnpj(String cnpj);
}
