package com.api.bonappetit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.bonappetit.dto.ContaDTO;
import com.api.bonappetit.model.Conta;
import com.api.bonappetit.model.Pedidos;
import com.api.bonappetit.model.PedidosItens;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ContaMapper {

	public Conta toEntity(ContaDTO obj) {
		Conta conta = new Conta();
		conta.setId(obj.getId());
		conta.setNome(obj.getNome());
		conta.setLogin(obj.getLogin());
		conta.setEndereco(obj.getEndereco());
		conta.setEmail(obj.getEmail());
		conta.setSenha(obj.getSenha());
		conta.setPerfis(obj.getPerfis());
		return conta;
	}
	
	public ContaDTO toDTO(Conta obj) {
		ContaDTO contaDTO = new ContaDTO();
		contaDTO.setId(obj.getId());
		contaDTO.setNome(obj.getNome());
		contaDTO.setLogin(obj.getLogin());
		contaDTO.setEndereco(obj.getEndereco());
		contaDTO.setEmail(obj.getEmail());
		contaDTO.setSenha(obj.getSenha());
		contaDTO.setPerfis(obj.getPerfisAsInteger());
		return contaDTO;
	}
	
	public List<Conta> toEntity(List<ContaDTO> list) {
		List<Conta> lista = new ArrayList<>();
		for (ContaDTO m : list) {
			lista.add(toEntity(m));
		}
		return lista;
	}

	public List<ContaDTO> toDTO(List<Conta> list) {
		List<ContaDTO> lista = new ArrayList<>();
		for (Conta m : list) {
			lista.add(toDTO(m));
		}
		return lista;
	}

}
