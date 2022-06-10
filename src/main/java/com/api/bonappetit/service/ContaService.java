package com.api.bonappetit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.bonappetit.dto.ContaDTO;
import com.api.bonappetit.exception.AuthorizationException;
import com.api.bonappetit.mapper.ContaMapper;
import com.api.bonappetit.model.Conta;
import com.api.bonappetit.repository.ContaRepository;
import com.api.bonappetit.security.JWTUtil;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ContaService implements ServiceInterface<ContaDTO>{
	
	@Autowired
	private ContaRepository repository;
	
	@Autowired	
	private ContaMapper mapper;
	
	
	@Override
	public List<ContaDTO> findAll() {
		return mapper.toDTO(repository.findAll());
	}
	
	private JWTUtil jwtUtil;
	
	
	@Override
	public ContaDTO findById(Long id) throws AuthorizationException {
		if (!jwtUtil.authorized(id)) {throw new AuthorizationException("Acesso negado!");}
		Optional<Conta> obj = repository.findById(id);
		if (obj.isPresent()) {
			return mapper.toDTO(obj.get());
		}
		return null;
	}
	
	@Override
	public boolean update(ContaDTO obj) {
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override 
	public ContaDTO create(ContaDTO obj) {
		obj.setSenha(passwordEncoder.encode(obj.getSenha()));
		Conta cnt = repository.save(mapper.toEntity(obj));
		return mapper.toDTO(cnt);
	}


	
}
