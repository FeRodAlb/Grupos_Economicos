package com.ferodalb.projeto1.gruposeconomicos.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaizInclusaoDTO {

	@NotNull(message = "Raiz Invalida")
	@NotBlank (message = "Raiz Invalida" )
	@Digits(integer = 8, fraction = 0, message = "Raiz deve conter 8 dígitos")
	private String raiz;
	
	@NotNull (message = "Nome raiz inválido")
	@NotBlank (message = "Nome raiz inválido")
	private String nome;
}
