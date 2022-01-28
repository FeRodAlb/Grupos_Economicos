package com.ferodalb.projeto1.gruposeconomicos.exception.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorFieldResponse {

	private String campo;
	
	private String mensagem;
	
	private String valor;
}
