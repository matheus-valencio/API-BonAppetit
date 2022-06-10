package com.api.bonappetit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bonappetit.model.PedidosItens;


@Repository
public interface PedidoItensRepository extends JpaRepository<PedidosItens, Long>{

}
