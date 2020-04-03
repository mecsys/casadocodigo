package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PedidosServicoController {

	@RequestMapping("/pedidos")
	public String listarPedidos( ) {
		
		return "URL /pedidos executada";
	}
	
}
