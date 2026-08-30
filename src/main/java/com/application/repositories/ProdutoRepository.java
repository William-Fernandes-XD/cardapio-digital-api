package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{


}
