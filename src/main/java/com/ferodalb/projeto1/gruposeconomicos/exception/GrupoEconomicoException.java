package com.ferodalb.projeto1.gruposeconomicos.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GrupoEconomicoException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public static final String CNPJ_INVALIDO = "CNPJ inválido";
	
	public static final String CNPJ_NAO_ENCONTRADO = "CNPJ não encontrado";
	
	public static final String CNPJ_JA_CADASTRADO_GRUPO = "CNPJ já cadastrado no grupo econômico do cnpj ";
	
	public static final String RAIZ_INVALIDA = "Raiz inválida";

	public static final String RAIZ_NAO_ENCONTRADA = "Raiz não encontrada";

	public static final String RAIZ_JA_CADASTRADA = "Raiz já cadastrada no grupo econômico do cnpj ";
	
	private HttpStatus status;
	
	private String codigo;
	
	private String mensagem;
	
	public static void throw400Exception(String codigo, String mensagem) {
		throw GrupoEconomicoException.builder()
				.status(HttpStatus.BAD_REQUEST)
				.codigo(codigo)
				.mensagem(mensagem)
				.build();
		
	}
	
	public static void throw404Exception(String codigo, String mensagem) {
		throw GrupoEconomicoException.builder()
				.status(HttpStatus.NOT_FOUND)
				.codigo(codigo)
				.mensagem(mensagem)
				.build();
	}
	
	public static void throw409Exception(String codigo, String mensagem) {
		throw GrupoEconomicoException.builder()
				.status(HttpStatus.CONFLICT)
				.codigo(codigo)
				.mensagem(mensagem)
				.build();
	}
	
	
}
