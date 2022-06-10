package com.api.bonappetit.dto;

import com.api.bonappetit.model.PedidosItens;
import com.api.bonappetit.model.Produto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoItensProdutosDTO {
	
	private Long id;
	
	private PedidosItens pedidosItens;

	private Produto produto;
	

}
