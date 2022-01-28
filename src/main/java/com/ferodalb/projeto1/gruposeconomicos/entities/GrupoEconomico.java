package com.ferodalb.projeto1.gruposeconomicos.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "TB_GRUPO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrupoEconomico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_GRPO_ECON")
	private Integer codigo_grupo;
	
	@Column(name = "NUM_CNPJ_GRPO_ECON", length = 14, nullable = false)
	private String cnpj;
	
	@Column(name = "NOM_GRPO_ECON", length = 30, nullable = false)
	private String descricao;
	
	@Column(name = "DAT_CAD_GRPO_ECON", nullable = false)
	private LocalDateTime data_cadastro;
	
	//mapped by sempre o nome do atributo
	//Por padrão, FETCH TYPE é SEMPRE LAZY
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo_economico")
	private List<Raiz> listaRaiz = new ArrayList<Raiz>();
	
}
