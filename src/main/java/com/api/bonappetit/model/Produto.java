package com.api.bonappetit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "tb_produtos")
public class Produto extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_produto")
	private String nome;
	
	@Column(name = "nm_imagem")
	private String produtoImagem;

	@Column(name = "vl_produto")
	private Float valor;

	@Column(name = "ds_produto")
	private String descricao;


	@Getter(onMethod = @__(@JsonProperty))
	@Setter(onMethod = @__(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	

}



