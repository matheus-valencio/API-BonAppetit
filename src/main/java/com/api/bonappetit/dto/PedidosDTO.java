package com.api.bonappetit.dto;

import java.util.Calendar;
import java.util.List;

import com.api.bonappetit.model.Conta;
import com.api.bonappetit.model.PedidosItens;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidosDTO {
	
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Calendar dataPedido;

	private List<PedidosItens> pedidosItens;

	private String enderecoPedido;
	
	private String observacaoPedido;
	
	private Conta conta;

}
