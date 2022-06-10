package com.api.bonappetit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.bonappetit.model.Conta;



@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	Conta findByLogin(String login);
}
