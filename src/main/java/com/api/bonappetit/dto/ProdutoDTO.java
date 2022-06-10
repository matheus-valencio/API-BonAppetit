package com.api.bonappetit.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.api.bonappetit.model.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO {
	
	private Long id;
	
	@NotBlank
	@Length(min = 3, max = 60)
	private String nome;
	
	private Float valor;
	
	private String descricao;
	
	private String produtoImagem;
	
	private Categoria categoria;
	
}
