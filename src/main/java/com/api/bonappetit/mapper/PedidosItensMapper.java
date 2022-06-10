package com.api.bonappetit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.bonappetit.dto.PedidosItensDTO;
import com.api.bonappetit.model.PedidoItensProdutos;
import com.api.bonappetit.model.PedidosItens;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PedidosItensMapper {

	public PedidosItens toEntity(PedidosItensDTO obj) {
		PedidosItens pedidosItens = new PedidosItens();
		pedidosItens.setId(obj.getId());
		pedidosItens.setQuantidade(obj.getQuantidade());
		pedidosItens.setObservacaoItem(obj.getObservacaoItem());
		pedidosItens.setPedidos(obj.getPedidos());
		pedidosItens.setPedidoItensProdutos(obj.getPedidoItensProdutos());
		for (PedidoItensProdutos pedidoItensProduto: pedidosItens.getPedidoItensProdutos())
			pedidoItensProduto.setPedidosItens(pedidosItens);
		return pedidosItens;
	}
	
	public PedidosItensDTO toDTO(PedidosItens obj) {
		PedidosItensDTO pedidosItensDTO = new PedidosItensDTO();
		pedidosItensDTO.setId(obj.getId());
		pedidosItensDTO.setQuantidade(obj.getQuantidade());
		pedidosItensDTO.setObservacaoItem(obj.getObservacaoItem());
		pedidosItensDTO.setPedidos(obj.getPedidos());
		pedidosItensDTO.setPedidoItensProdutos(obj.getPedidoItensProdutos());
		return pedidosItensDTO;
	}
	
	public List<PedidosItens> toEntity(List<PedidosItensDTO> list) {
		List<PedidosItens> lista = new ArrayList<>();
		for (PedidosItensDTO m : list) {
			lista.add(toEntity(m));
		}
		return lista;
	}

	public List<PedidosItensDTO> toDTO(List<PedidosItens> list) {
		List<PedidosItensDTO> lista = new ArrayList<>();
		for (PedidosItens m : list) {
			lista.add(toDTO(m));
		}
		return lista;
	}

}
