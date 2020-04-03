package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Produto;

@Controller
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/pedidos")
	public ModelAndView listarPedidos(RedirectAttributes model) {
		
		ModelAndView modelAndView = new ModelAndView("pedidos");
		
		final String uri = "https://book-payment.herokuapp.com/orders";
		String response = restTemplate.getForObject(uri, String.class);
		
		System.out.println(response);
		
		modelAndView.addObject("pedidos", response);
		model.addFlashAttribute("sucesso", "Lista de Produtos Obtida com Sucesso");
		
		return modelAndView;
	}
	
}
