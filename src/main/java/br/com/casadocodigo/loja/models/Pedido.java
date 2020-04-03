package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pedido {

	private int id;

	private BigDecimal valor;

	private Calendar data;

	private List<Produto> produtos = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	};
	
	@Override
	public String toString() {
		
		return "Pedido [id=" + id + ", valor=" + valor + ", data=" + data + ", produtos=" + produtos + "]";
		
	}

}
