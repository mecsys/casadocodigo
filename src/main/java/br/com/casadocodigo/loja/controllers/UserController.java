package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
public class UserController {

	// semelhante ao cadastro de produtos
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.addValidators(new UsuarioValidation());
//	}
	
	@RequestMapping("/usuarios")
	public ModelAndView listarUsuarios(RedirectAttributes model) {
		
		final List<Usuario> usuarios;
		
		usuarios = usuarioDao.listar();
		
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);

		return modelAndView;
		
	}
	
//	@RequestMapping("/usuario/form")
//	public ModelAndView form(Usuario usuario) {
//		
//		return new ModelAndView("produtos/form");
//		
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, 
//			RedirectAttributes model) {
//		
//		if(result.hasErrors()) {
//			return form(usuario);
//		}
//		
//		usuarioDao.gravar(usuario);
//		
//		model.addFlashAttribute("sucesso", "Usuario cadastrado com sucesso!");
//		
//		return new ModelAndView("usuarios/lista");
//		
//	}
	
}
