package com.application.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CardapioDia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cardapio_dia;
	
	private String titulo;
	private String descricao;
	private LocalDateTime data;
	
	@OneToMany(mappedBy = "cardapioDia")
	private List<CardapioProdutoDia> cardapioProdutoDias;

	public Long getId_cardapio_dia() {
		return id_cardapio_dia;
	}

	public void setId_cardapio_dia(Long id_cardapio_dia) {
		this.id_cardapio_dia = id_cardapio_dia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public List<CardapioProdutoDia> getCardapioProdutoDias() {
		return cardapioProdutoDias;
	}

	public void setCardapioProdutoDias(List<CardapioProdutoDia> cardapioProdutoDias) {
		this.cardapioProdutoDias = cardapioProdutoDias;
	}
	
	
}
