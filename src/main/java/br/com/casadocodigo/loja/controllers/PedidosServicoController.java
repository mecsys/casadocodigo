package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Produto;

@Controller
public class PedidosServicoController {
	
	private RestTemplate restTemplate;

	@RequestMapping("/pedidos")
	public ModelAndView listarPedidos(RedirectAttributes model) {
		
		String uri = "https://book-payment.herokuapp.com/orders";
		String response = restTemplate.getForObject(uri, String.class);
		
		System.out.println(response);
		
		model.addFlashAttribute("sucesso", "Lista de Produtos Obtida com Sucesso");
		
		return new ModelAndView("redirect:pedidos");
	}
	
}
