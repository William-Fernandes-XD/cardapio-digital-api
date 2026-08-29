package com.application.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.entities.Pedido;

public interface PedidoInterface extends JpaRepository<Pedido, Long> {
	
}
