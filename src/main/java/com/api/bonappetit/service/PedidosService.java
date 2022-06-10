package com.api.bonappetit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bonappetit.dto.PedidosDTO;
import com.api.bonappetit.mapper.PedidosMapper;
import com.api.bonappetit.model.Pedidos;
import com.api.bonappetit.repository.PedidosRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PedidosService implements ServiceInterface<PedidosDTO>{
	
	@Autowired
	private PedidosRepository repository;
		
	@Autowired	
	private PedidosMapper mapper;
	
	@Override
	public PedidosDTO create(PedidosDTO obj) {
		Pedidos pedidos = repository.save(mapper.toEntity(obj));
		return mapper.toDTO(pedidos);
	}
	
	@Override
	public List<PedidosDTO> findAll() {
		return mapper.toDTO(repository.findAll());
	}
	
	@Override
	public PedidosDTO findById(Long id) {
		Optional<Pedidos> obj = repository.findById(id);
		if (obj.isPresent()) {
			return mapper.toDTO(obj.get());
		}
		return null;
	}
	
	@Override
	public boolean update(PedidosDTO obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(mapper.toEntity(obj));
			return true;
		}
		return false;
	}
	
	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}



	
}
