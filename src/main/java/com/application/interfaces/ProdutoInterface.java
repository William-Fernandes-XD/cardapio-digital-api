package com.application.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.entities.Produto;

public interface ProdutoInterface extends JpaRepository<Produto, Long>{


}
