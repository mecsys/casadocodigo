package br.com.casadocodigo.loja.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;


/**
 * 
 * @author Isaac Mecchi
 *
 * TODO: 	https://cursos.alura.com.br/course/projeto-java/task/40684
 * 			
 * 			A implementação do serviço 
 * 			deve ser feita dentro de uma nova classe 
 * 			com o nome RelatorioProdutosController. 
 * 
 * 			O acesso ao banco de dados 
 * 			deve ser feito dentro do ProdutoDAO.
 * 
 * 			Você pode ver uma implementação de um web service nessa aula:
 * 
 * 			https://cursos.alura.com.br/course/springmvc-2-integracao-cache-seguranca-e-templates/task/12233
 */

@RestController
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping(value = "/relatorio-produtos", method = RequestMethod.GET)
	public String relatorioProdutosJson() {
		
		List<Produto> produtos = produtoDao.listar();
		
		ObjectMapper report = new ObjectMapper();
		
		String json = "";
		
		try {
			
			JsonNode node = report.createObjectNode();
			ObjectNode newNode = ((ObjectNode) node).put("dataGeracao", new Date().getTime());
			newNode
				.put("quantidade", produtos.size())
				.put("produtos", report.writeValueAsString(produtos));
			
			json = report.writeValueAsString(newNode);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			
		}
		return json;
		
	}

}
