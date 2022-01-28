package com.ferodalb.projeto1.gruposeconomicos.exception.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorWrapperResponse {

	private String status;
	
	private String mensagem;
	
	private List<ErrorFieldResponse> campos;
}
