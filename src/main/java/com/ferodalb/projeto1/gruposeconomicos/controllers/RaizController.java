package com.ferodalb.projeto1.gruposeconomicos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ferodalb.projeto1.gruposeconomicos.controllers.request.RaizInclusaoRequest;
import com.ferodalb.projeto1.gruposeconomicos.dto.RaizDTO;
import com.ferodalb.projeto1.gruposeconomicos.service.RaizService;

@RestController
public class RaizController {

	@Autowired
	private RaizService raizService;

	
	@GetMapping(path = "/{cnpj}/raizes")
	public ResponseEntity<List<RaizDTO>> consultaRaizes(
			@PathVariable (name = "cnpj") String cnpj){
		
		return ResponseEntity.ok(raizService.consultaRaizesGrupo(cnpj));
		
	}
	
	@PostMapping(path = "/{cnpj}/raizes")
	public ResponseEntity<Void> incluiRaiz(
		@PathVariable (name = "cnpj") String cnpj,
		@Valid @RequestBody RaizInclusaoRequest request	){
	
		raizService.incluiRaiz(cnpj, request);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();	
			
	}

	@DeleteMapping(path = "/{cnpj}/raizes/{raiz}")
	public ResponseEntity<Void> deletaRaiz(
			@PathVariable (name = "cnpj") String cnpj,
			@PathVariable (name = "raiz") String raiz){
		
		raizService.deletaRaizGrupo(cnpj, raiz);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
