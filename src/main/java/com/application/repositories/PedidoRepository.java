package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
