package com.ferodalb.projeto1.gruposeconomicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CnpjDTO {

	private String cnpj;
	private String razao_social;
	private Integer id;
	private Integer id_grupo;
	private String cnpj_mae;
	
}
