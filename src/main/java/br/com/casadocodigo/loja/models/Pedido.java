package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Pedido {

	private int id;

	private BigDecimal valor;

	@DateTimeFormat
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
	
	public String getDataFormatada() {
		
		   SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yy");
		   String formatted = format1.format(data.getTime());
		
		return formatted;
		
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
