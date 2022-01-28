package com.ferodalb.projeto1.gruposeconomicos.service;

import java.util.List;

import com.ferodalb.projeto1.gruposeconomicos.controllers.request.RaizInclusaoRequest;
import com.ferodalb.projeto1.gruposeconomicos.dto.RaizDTO;


public interface RaizService {
	
	List<RaizDTO> consultaRaizesGrupo(String cnpj);
	
	void incluiRaiz(String cnpj, RaizInclusaoRequest request);
	
	void deletaRaizGrupo(String cnpj, String raiz);

}
