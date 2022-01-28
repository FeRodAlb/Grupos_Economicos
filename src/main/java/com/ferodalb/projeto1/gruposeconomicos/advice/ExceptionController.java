package com.ferodalb.projeto1.gruposeconomicos.advice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ferodalb.projeto1.gruposeconomicos.exception.GrupoEconomicoException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(GrupoEconomicoException.class)
	public ResponseEntity<Object> grupoEconomicoErrorExceptionHandler(GrupoEconomicoException e){
	
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("valor", e.getCodigo());
		body.put("mensagem", e.getMensagem());
		
		return new ResponseEntity<Object>(body, e.getStatus());
		
		
	}
}
