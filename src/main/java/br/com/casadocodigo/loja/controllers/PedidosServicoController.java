package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/pedidos")
	public ModelAndView listarPedidos(RedirectAttributes model) {
		
		ModelAndView modelAndView = new ModelAndView("pedidos");
		
		final String uri = "https://book-payment.herokuapp.com/orders";
		
		 ResponseEntity<Pedido[]> response = restTemplate.getForEntity(uri, Pedido[].class);
		 Pedido[] pedidos = response.getBody();
		 
		 for (Pedido pedido : pedidos) {
			
			 System.out.println("Lista de pedidos: " + pedidos);
			 System.out.println("---");
			 
		}
		
		modelAndView.addObject("pedidos", pedidos);
		model.addFlashAttribute("sucesso", "Lista de Produtos Obtida com Sucesso");
		
		return modelAndView;
	}
	
}
