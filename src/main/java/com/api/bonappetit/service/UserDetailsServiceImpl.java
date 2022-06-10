package com.api.bonappetit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.bonappetit.model.Conta;
import com.api.bonappetit.repository.ContaRepository;
import com.api.bonappetit.security.UserDetailsImpl;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ContaRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Conta conta = repo.findByLogin(username);
		if (conta == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(conta.getId(), conta.getLogin(), conta.getSenha(), conta.getPerfis());
	}

}
