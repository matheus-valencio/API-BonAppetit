package com.api.bonappetit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.bonappetit.dto.PedidosDTO;
import com.api.bonappetit.model.Pedidos;
import com.api.bonappetit.model.PedidosItens;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PedidosMapper {

	public Pedidos toEntity(PedidosDTO obj) {
		Pedidos pedidos = new Pedidos();
		pedidos.setId(obj.getId());
		pedidos.setDataPedido(obj.getDataPedido());
		pedidos.setEnderecoPedido(obj.getEnderecoPedido());
		pedidos.setPedidosItens(obj.getPedidosItens());
		for (PedidosItens pedidosItens: pedidos.getPedidosItens())
		    pedidosItens.setPedidos(pedidos);
		pedidos.setConta(obj.getConta());
		return pedidos;
	}
	
	public PedidosDTO toDTO(Pedidos obj) {
		PedidosDTO pedidosDTO = new PedidosDTO();
		pedidosDTO.setId(obj.getId());
		pedidosDTO.setDataPedido(obj.getDataPedido());
		pedidosDTO.setEnderecoPedido(obj.getEnderecoPedido());
		pedidosDTO.setPedidosItens(obj.getPedidosItens());
		pedidosDTO.setConta(obj.getConta());
		return pedidosDTO;
	}
	
	public List<Pedidos> toEntity(List<PedidosDTO> list) {
		List<Pedidos> lista = new ArrayList<>();
		for (PedidosDTO m : list) {
			lista.add(toEntity(m));
		}
		return lista;
	}

	public List<PedidosDTO> toDTO(List<Pedidos> list) {
		List<PedidosDTO> lista = new ArrayList<>();
		for (Pedidos m : list) {
			lista.add(toDTO(m));
		}
		return lista;
	}

}
