package com.ferodalb.projeto1.gruposeconomicos.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferodalb.projeto1.gruposeconomicos.controllers.request.RaizInclusaoRequest;
import com.ferodalb.projeto1.gruposeconomicos.dto.RaizDTO;
import com.ferodalb.projeto1.gruposeconomicos.entities.Cnpj;
import com.ferodalb.projeto1.gruposeconomicos.entities.Raiz;
import com.ferodalb.projeto1.gruposeconomicos.exception.GrupoEconomicoException;
import com.ferodalb.projeto1.gruposeconomicos.repo.CnpjDAO;
import com.ferodalb.projeto1.gruposeconomicos.repo.RaizDAO;
import com.ferodalb.projeto1.gruposeconomicos.service.RaizService;
import com.ferodalb.projeto1.gruposeconomicos.util.Helper;

@Service
public class RaizServiceImpl implements RaizService {
	
	@Autowired
	private CnpjDAO cnpjDao;
	
	@Autowired
	private RaizDAO raizDao;

	public List<RaizDTO> consultaRaizesGrupo(String cnpj){
		
		if (!Helper.isCnpj(cnpj)) {
			GrupoEconomicoException.throw400Exception(cnpj, GrupoEconomicoException.CNPJ_INVALIDO);
		}
		
		Cnpj c = cnpjDao.findByCnpj(cnpj);
		
		if (c == null) {
			GrupoEconomicoException.throw404Exception(cnpj, GrupoEconomicoException.CNPJ_NAO_ENCONTRADO);
		}
				
		List<Raiz> lista = raizDao.findPorGrupo(c.getRaiz().getGrupo_economico().getCodigo_grupo());
		List<RaizDTO> listaDto = new ArrayList<RaizDTO>();
		
		for (Raiz raiz : lista) {
			listaDto.add(RaizDTO.builder()
								.raiz(raiz.getRaiz())
								.nome_raiz(raiz.getDescricao())
								.total_filiais(raiz.getListaCnpjs().size())
								.build());	
		}
		
		return listaDto;
		
	};
	
	public void incluiRaiz(String cnpj, RaizInclusaoRequest request) {
		
		if (!Helper.isCnpj(cnpj)) {
			GrupoEconomicoException.throw400Exception(cnpj, GrupoEconomicoException.CNPJ_INVALIDO);
		}
		
		Cnpj c = cnpjDao.findByCnpj(cnpj);
		
		if (c == null) {
			GrupoEconomicoException.throw404Exception(cnpj, GrupoEconomicoException.CNPJ_NAO_ENCONTRADO);
		}
		
		Optional<Raiz> raiz = raizDao.findById(request.getRaiz());
		
		if (raiz.isPresent()) {
			GrupoEconomicoException.throw409Exception(request.getRaiz(), GrupoEconomicoException.RAIZ_JA_CADASTRADA + raiz.get().getGrupo_economico().getCnpj());
		}
		
		raizDao.save(
				Raiz.builder()
				.raiz(request.getRaiz())
				.descricao(request.getNome())
				.data_cadastro(LocalDateTime.now())
				.grupo_economico(c.getRaiz().getGrupo_economico())
				.build()
				);
			
	}
	
	public void deletaRaizGrupo(String cnpj, String raiz) {
		
		
		if (!Helper.isCnpj(cnpj)) {
			GrupoEconomicoException.throw400Exception(cnpj, GrupoEconomicoException.CNPJ_INVALIDO);
		}
		
		if (!Helper.isRaiz(raiz)) {
			GrupoEconomicoException.throw400Exception(raiz, GrupoEconomicoException.RAIZ_INVALIDA);			
		}
		
		Cnpj c = cnpjDao.findByCnpj(cnpj);
		
		if (c == null) {
			GrupoEconomicoException.throw404Exception(cnpj, GrupoEconomicoException.CNPJ_NAO_ENCONTRADO);
		}
		
		Optional<Raiz> object = raizDao.findById(raiz);
		
		if (!object.isPresent()) {
			GrupoEconomicoException.throw404Exception(cnpj, GrupoEconomicoException.RAIZ_NAO_ENCONTRADA);
		} else if (!object.get().getGrupo_economico().getCodigo_grupo().equals(c.getRaiz().getGrupo_economico().getCodigo_grupo())) {
			GrupoEconomicoException.throw404Exception(cnpj, GrupoEconomicoException.RAIZ_NAO_ENCONTRADA);
		}
		
		raizDao.delete(object.get());
		
	}


}

