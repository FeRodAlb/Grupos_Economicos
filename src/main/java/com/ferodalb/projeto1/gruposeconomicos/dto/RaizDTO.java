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
public class RaizDTO {

	private String raiz;
	private String nome_raiz;
	private Integer total_filiais;
	
}
