package com.ferodalb.projeto1.gruposeconomicos.controllers.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import com.ferodalb.projeto1.gruposeconomicos.messages.GrupoEconomicoMessages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaizInclusaoRequest {

	@NotEmpty (message = GrupoEconomicoMessages.RAIZ_INVALIDA )
	@Digits(integer = 8, fraction = 0, message = "Raiz deve conter 8 dígitos")
	private String raiz;

	@NotEmpty(message = GrupoEconomicoMessages.NOME_RAIZ_INVALIDO)
	private String nome;
	
}
