package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

@Controller
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/relatorio-produtos")
	public String relatorioProdutos() {
		
		List<Produto> produtos = produtoDao.listar();
		
		return "URL /relatorio-produtos executada";
		
	}

}
