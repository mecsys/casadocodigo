package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Produto> relatorioProdutosJson() {
		
		List<Produto> produtos = produtoDao.listar();
		
		for (Produto produto : produtos) {
			System.out.println(produto.toString());
		}
		
		return produtos;
		
	}

}
