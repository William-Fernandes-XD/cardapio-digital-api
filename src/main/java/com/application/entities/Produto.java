package com.application.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produto;
	
	@Column(name = "preco")
	private Double preco;
	
	@Column(name = "nomeProduto", length = 45)
	private String nomeProduto;
	
	@Column(name = "disponivel")
	private int disponivel;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "nomeProduto", columnDefinition = "TEXT")
	private String descricao;
	
	@OneToMany(mappedBy = "produto")
	private List<ItemPedido> itensPedidos;
	
	@OneToMany(mappedBy = "produto")
	private List<CardapioProdutoDia> cardapioProdutoDias;
	
	public List<CardapioProdutoDia> getCardapioProdutoDias() {
		return cardapioProdutoDias;
	}
	
	public void setCardapioProdutoDias(List<CardapioProdutoDia> cardapioProdutoDias) {
		this.cardapioProdutoDias = cardapioProdutoDias;
	}

	public Long getId_produto() {
		return id_produto;
	}
	
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}
	
	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
