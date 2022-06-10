package com.api.bonappetit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bonappetit.model.Pedidos;




@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

}
