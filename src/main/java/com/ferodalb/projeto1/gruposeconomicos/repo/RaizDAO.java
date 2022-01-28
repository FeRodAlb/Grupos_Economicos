package com.ferodalb.projeto1.gruposeconomicos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ferodalb.projeto1.gruposeconomicos.entities.Raiz;

public interface RaizDAO extends JpaRepository<Raiz, String>{

	@Query("select r from TB_RAIZ r where r.grupo_economico.codigo_grupo = :id")
	List<Raiz> findPorGrupo(@Param("id")Integer id);
	
	Raiz findByRaiz(String raiz);
}
