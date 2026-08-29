package com.application.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_item_pedido;
	
	private Double precoUnit;
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false)
	private Pedido pedido;

	public Long getId_item_pedido() {
		return id_item_pedido;
	}
	
	public void setId_item_pedido(Long id_item_pedido) {
		this.id_item_pedido = id_item_pedido;
	}
	
	public Double getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(Double precoUnit) {
		this.precoUnit = precoUnit;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
