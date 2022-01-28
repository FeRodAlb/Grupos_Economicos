package com.ferodalb.projeto1.gruposeconomicos.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ferodalb.projeto1.gruposeconomicos.exception.response.ErrorFieldResponse;
import com.ferodalb.projeto1.gruposeconomicos.exception.response.ErrorWrapperResponse;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{

	private static final String INVALID_FIELDS = "Erro na validação dos campos informados";
	
	//Essa exceção ocorre quando ocorre um erro de validação annotations
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers, 
			HttpStatus status, 
			WebRequest request) {
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ErrorFieldResponse> lista = new ArrayList<>();
				
		for (FieldError fieldError : fieldErrors) {
			lista.add(ErrorFieldResponse.builder()
					.campo(fieldError.getField())
					.mensagem(fieldError.getDefaultMessage())
					.valor(Objects.requireNonNullElse(fieldError.getRejectedValue(), "Null").toString())
					.build());	
		}

		
		HttpStatus errorCode = HttpStatus.UNPROCESSABLE_ENTITY;
			
		ErrorWrapperResponse response = ErrorWrapperResponse.builder()
		.status(String.valueOf(errorCode.value()))
		.mensagem(INVALID_FIELDS)
		.campos(lista)
		.build();
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorWrapperResponse> handleIllegalArgumentException(IllegalArgumentException ex){
		
		HttpStatus errorCode = HttpStatus.UNPROCESSABLE_ENTITY;
		
		ErrorWrapperResponse response = ErrorWrapperResponse.builder()
			.status(String.valueOf(errorCode.value()))
			.mensagem(ex.getMessage())
			.build();
		
		return ResponseEntity.status(errorCode).body(response);
		
		
	}
	
	
}
