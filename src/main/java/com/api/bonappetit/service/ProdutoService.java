package com.api.bonappetit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bonappetit.dto.ProdutoDTO;
import com.api.bonappetit.mapper.ProdutoMapper;
import com.api.bonappetit.model.Produto;
import com.api.bonappetit.repository.ProdutoRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ProdutoService implements ServiceInterface<ProdutoDTO>{
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired	
	private ProdutoMapper mapper;
	
	@Override
	public ProdutoDTO create(ProdutoDTO obj) {
		Produto produto = repository.save(mapper.toEntity(obj));
		return mapper.toDTO(produto);
	}
	
	@Override
	public List<ProdutoDTO> findAll() {
		return mapper.toDTO(repository.findAll());
	}
	
	@Override
	public ProdutoDTO findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		if (obj.isPresent()) {
			return mapper.toDTO(obj.get());
		}
		return null;
	}
	
	@Override
	public boolean update(ProdutoDTO obj) {
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
