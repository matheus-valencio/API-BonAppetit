package com.api.bonappetit.dto;

import java.util.List;

import com.api.bonappetit.model.PedidoItensProdutos;
import com.api.bonappetit.model.Pedidos;
import com.api.bonappetit.model.PedidosItens;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidosItensDTO {
	
	private Long id;

	private Integer quantidade;

	private String observacaoItem;
	

	private Pedidos pedidos;
	
	private List<PedidoItensProdutos> pedidoItensProdutos;
}
