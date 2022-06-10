package com.api.bonappetit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.bonappetit.dto.PedidoItensProdutosDTO;
import com.api.bonappetit.model.PedidoItensProdutos;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PedidoItensProdutosMapper {

	public PedidoItensProdutos toEntity(PedidoItensProdutosDTO obj) {
		PedidoItensProdutos pedidoItensProdutos = new PedidoItensProdutos();
		pedidoItensProdutos.setId(obj.getId());
		pedidoItensProdutos.setPedidosItens(obj.getPedidosItens());
		pedidoItensProdutos.setProduto(obj.getProduto());
		return pedidoItensProdutos;
	}
	
	public PedidoItensProdutosDTO toDTO(PedidoItensProdutos obj) {
		PedidoItensProdutosDTO pedidoItensProdutosDTO = new PedidoItensProdutosDTO();
		pedidoItensProdutosDTO.setId(obj.getId());
		pedidoItensProdutosDTO.setPedidosItens(obj.getPedidosItens());
		pedidoItensProdutosDTO.setProduto(obj.getProduto());
		return pedidoItensProdutosDTO;
	}
	
	public List<PedidoItensProdutos> toEntity(List<PedidoItensProdutosDTO> list) {
		List<PedidoItensProdutos> lista = new ArrayList<>();
		for (PedidoItensProdutosDTO m : list) {
			lista.add(toEntity(m));
		}
		return lista;
	}

	public List<PedidoItensProdutosDTO> toDTO(List<PedidoItensProdutos> list) {
		List<PedidoItensProdutosDTO> lista = new ArrayList<>();
		for (PedidoItensProdutos m : list) {
			lista.add(toDTO(m));
		}
		return lista;
	}

}
