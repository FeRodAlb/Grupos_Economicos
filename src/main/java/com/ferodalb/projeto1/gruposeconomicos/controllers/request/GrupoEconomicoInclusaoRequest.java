package com.ferodalb.projeto1.gruposeconomicos.controllers.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.ferodalb.projeto1.gruposeconomicos.messages.GrupoEconomicoMessages;

import br.com.caelum.stella.bean.validation.CNPJ;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoEconomicoInclusaoRequest {


	@NotEmpty(message = GrupoEconomicoMessages.CNPJ_INVALIDO)
	@CNPJ(formatted = false, message = GrupoEconomicoMessages.CNPJ_INVALIDO )
	private String cnpj;
	
	@NotEmpty(message = GrupoEconomicoMessages.NOME_CNPJ_INVALIDO)
	@Length(max = 30, message = GrupoEconomicoMessages.NOME_CNPJ_INVALIDO_TAMANHO)
	private String nome;
	
	@NotEmpty(message = GrupoEconomicoMessages.NOME_ABR_INVALIDO)
	@Length(max = 15, message = GrupoEconomicoMessages.NOME_ABR_INVALIDO_TAMANHO)
	private String nome_abreviado;
	
}
