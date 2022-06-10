package com.api.bonappetit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bonappetit.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
