package com.ferodalb.projeto1.gruposeconomicos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferodalb.projeto1.gruposeconomicos.controllers.request.GrupoEconomicoInclusaoRequest;
import com.ferodalb.projeto1.gruposeconomicos.service.GrupoService;

@RestController
@RequestMapping(path = "/api/grupo_economico")
public class GrupoController {
	
	@Autowired
	private GrupoService grupoService;
	
	@PostMapping
	public ResponseEntity<Void> incluiGrupo(
			@Valid @RequestBody GrupoEconomicoInclusaoRequest request){
		
		grupoService.incluiGrupo(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
}
