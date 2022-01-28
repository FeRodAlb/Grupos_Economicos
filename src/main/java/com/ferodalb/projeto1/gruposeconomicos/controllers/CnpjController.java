package com.ferodalb.projeto1.gruposeconomicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferodalb.projeto1.gruposeconomicos.dto.CnpjDTO;
import com.ferodalb.projeto1.gruposeconomicos.service.CnpjService;

@RestController
@RequestMapping(path = "/api/cnpj")
public class CnpjController {

	@Autowired
	private CnpjService service;
	
	@GetMapping(path = "/{cnpj}")
	public ResponseEntity<CnpjDTO> consultaCNPJ(
		@PathVariable(name = "cnpj") String cnpj)
	{
		
		return ResponseEntity.ok(service.consultaCNPJ(cnpj));			
		
	}
	
}
