package com.ferodalb.projeto1.gruposeconomicos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferodalb.projeto1.gruposeconomicos.dto.CnpjDTO;
import com.ferodalb.projeto1.gruposeconomicos.entities.Cnpj;
import com.ferodalb.projeto1.gruposeconomicos.exception.GrupoEconomicoException;
import com.ferodalb.projeto1.gruposeconomicos.repo.CnpjDAO;
import com.ferodalb.projeto1.gruposeconomicos.service.CnpjService;
import com.ferodalb.projeto1.gruposeconomicos.util.Helper;

@Service
public class CnpjServiceImpl implements CnpjService{

	@Autowired
	private CnpjDAO dao;

	public CnpjDTO consultaCNPJ(String cnpj){
		
		validarCnpj(cnpj);
		
		Cnpj c = dao.findByCnpj(cnpj);
		
		if (c == null) {
			GrupoEconomicoException.throw404Exception(cnpj, GrupoEconomicoException.CNPJ_NAO_ENCONTRADO);
		} 
		
		return CnpjDTO.builder()
					.cnpj(c.getCnpj())
					.razao_social(c.getDescricao())
					.id(c.getCodigo_cnpj())
					.id_grupo(c.getRaiz().getGrupo_economico().getCodigo_grupo())
					.cnpj_mae(c.getRaiz().getGrupo_economico().getCnpj())
					.build();
	}

	
	private void validarCnpj(String valor) {
		
		boolean isNumeric = Helper.onlyNumbers(valor);
		
		if (isNumeric && valor.length() == 14) {
			System.out.println("OK");
		} else {
			GrupoEconomicoException.throw400Exception(valor, GrupoEconomicoException.CNPJ_INVALIDO);
		}
		
	}

}
