package com.ferodalb.projeto1.gruposeconomicos.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="TB_RAIZ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Raiz {

	@Id
	@Column(name = "COD_RAIZ_CNPJ", length = 8)
	private String raiz;
	
	@Column(name = "NOM_RAIZ_CNPJ", length = 30, nullable = false)
	private String descricao;
	
	@Column(name = "DAT_CAD_RAIZ", nullable = false)
	private LocalDateTime data_cadastro;
	
	@ManyToOne
	@JoinColumn(name = "COD_GRPO_ECON", nullable = false)
	private GrupoEconomico grupo_economico;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "raiz", cascade = CascadeType.REMOVE)
	private List<Cnpj> listaCnpjs = new ArrayList<Cnpj>();
}
