package com.ferodalb.projeto1.gruposeconomicos.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferodalb.projeto1.gruposeconomicos.controllers.request.GrupoEconomicoInclusaoRequest;
import com.ferodalb.projeto1.gruposeconomicos.entities.Cnpj;
import com.ferodalb.projeto1.gruposeconomicos.entities.GrupoEconomico;
import com.ferodalb.projeto1.gruposeconomicos.entities.Raiz;
import com.ferodalb.projeto1.gruposeconomicos.messages.GrupoEconomicoMessages;
import com.ferodalb.projeto1.gruposeconomicos.repo.CnpjDAO;
import com.ferodalb.projeto1.gruposeconomicos.repo.GrupoDAO;
import com.ferodalb.projeto1.gruposeconomicos.repo.RaizDAO;
import com.ferodalb.projeto1.gruposeconomicos.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {

	@Autowired
	private CnpjDAO cnpjDao;

	@Autowired
	private RaizDAO raizDao;
	
	@Autowired
	private GrupoDAO grupoDao;

	@Transactional
	public void incluiGrupo(GrupoEconomicoInclusaoRequest request) {
		
		String cnpj = request.getCnpj();
		String raiz = cnpj.substring(0, 8);
		
		//validar se cnpj já tem grupo econômico cadastrado
		if (grupoDao.findByCnpj(cnpj) != null) {
			throw new IllegalArgumentException(GrupoEconomicoMessages.GRUPO_JA_CADASTRADO);
		}
		
		//Validar se cnpj já está cadastrado em outro grupo econômico
		Cnpj c = cnpjDao.findByCnpj(cnpj);
		
		if (c != null) {
			throw new IllegalArgumentException(GrupoEconomicoMessages.CNPJ_JA_CADASTRADO_GRUPO + c.getRaiz().getGrupo_economico().getCnpj());
		} 
		
		Raiz r = raizDao.findByRaiz(raiz);
				
		if (r != null) {
			throw new IllegalArgumentException(GrupoEconomicoMessages.RAIZ_JA_CADASTRADA_GRUPO + r.getGrupo_economico().getCnpj());			
		}
		
		GrupoEconomico ge = GrupoEconomico.builder()
			.cnpj(cnpj)
			.data_cadastro(LocalDateTime.now())
			.descricao(request.getNome())
			.listaRaiz(null)
			.build();
			
		grupoDao.save(ge);

		Raiz raiz2 = Raiz.builder()
			.raiz(raiz)
			.descricao(request.getNome_abreviado())
			.data_cadastro(LocalDateTime.now())
			.grupo_economico(ge)
			.listaCnpjs(null)
			.build();
		
		raizDao.save(raiz2);
		
		cnpjDao.save(
				Cnpj.builder()
					.cnpj(cnpj)
					.descricao(request.getNome())
					.raiz(raiz2)
					.data_cadastro(LocalDateTime.now())
					.build()
				);
		
	}
	
}
