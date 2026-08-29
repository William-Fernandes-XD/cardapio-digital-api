package com.application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CardapioProdutoDia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cardapio_produto_dia;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_cardapio_dia")
	private CardapioDia cardapioDia;

	public int getId_cardapio_produto_dia() {
		return id_cardapio_produto_dia;
	}

	public void setId_cardapio_produto_dia(int id_cardapio_produto_dia) {
		this.id_cardapio_produto_dia = id_cardapio_produto_dia;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CardapioDia getCardapioDia() {
		return cardapioDia;
	}

	public void setCardapioDia(CardapioDia cardapioDia) {
		this.cardapioDia = cardapioDia;
	}
}
