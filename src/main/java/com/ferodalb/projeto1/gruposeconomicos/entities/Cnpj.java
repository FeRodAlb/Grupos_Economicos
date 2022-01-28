package com.ferodalb.projeto1.gruposeconomicos.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "TB_CNPJ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cnpj {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_cnpj;
	
	@Column(name = "NUM_CNPJ_CLIE", length = 14, nullable = false)
	private String cnpj;
	
	@Column(name = "NOM_CNPJ_CLIE", length = 30, nullable = false)
	private String descricao;
	
	@Column(name = "DAT_CAD_CNPJ", nullable = false)
	private LocalDateTime data_cadastro;
	
	@ManyToOne
	@JoinColumn(name = "COD_RAIZ_CNPJ", nullable = false)
	private Raiz raiz;
}
