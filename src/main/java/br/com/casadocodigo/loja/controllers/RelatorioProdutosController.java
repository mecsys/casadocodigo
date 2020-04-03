package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
 */

@Controller
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@ResponseBody
	@RequestMapping(value = "/relatorio-produtos", method = RequestMethod.GET)
	public String relatorioProdutosJson(@RequestParam(value = "data", required = false) String data) {
		
		final List<Produto> produtos;
		
		if (data != null) {
			
			produtos = produtoDao.listar(data);
			
		} else  {
				
			produtos = produtoDao.listar();
				
		}
		
		ObjectMapper report = new ObjectMapper();
		
		String json = "";
		
		try {
			
			// Criar um nó JSON para manipular
			JsonNode jsonNode = report.createObjectNode();
			
			// Criar um objectNode para acrescentar nós aninhados
			ObjectNode objectNode = ((ObjectNode) jsonNode).put("dataGeracao", new Date().getTime());
			objectNode.put("quantidade", produtos.size());
			
			// Converter o objeto lista de produtos em um nó JSON
			// e adicionar a um atributo, como no aninhado.
			jsonNode = report.valueToTree(produtos);
			objectNode.put("produtos", jsonNode);
			
			// Converter o objeto JSON em uma String
			json = report.writeValueAsString(objectNode);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			
		}
		
		return json;
		
	}

}
