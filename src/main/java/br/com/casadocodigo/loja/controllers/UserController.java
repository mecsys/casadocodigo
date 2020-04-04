package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
public class UserController {

	// semelhante ao cadastro de produtos
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}
	
	@RequestMapping("/usuarios")
	public ModelAndView listarUsuarios(RedirectAttributes model) {
		
		final List<Usuario> usuarios;
		
		usuarios = usuarioDao.listar();
		
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);

		return modelAndView;
		
	}
	
	@RequestMapping("/usuarios/form")
	public ModelAndView form(Usuario usuario) {
		
		return new ModelAndView("usuarios/form");
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, 
			RedirectAttributes model) {
		
		if(result.hasErrors()) {
			
			model.addFlashAttribute("falha", "Erro no cadastro de usuario!");
			return form(usuario);
			
		}
		
		if(usuarioDao.hasUserByUsername(usuario.getEmail())) {
			
			model.addFlashAttribute("falha", "Usuario ja cadastrado!");
			return new ModelAndView("usuarios/lista");
		}
		
		usuarioDao.gravar(usuario);
		
		model.addFlashAttribute("sucesso", "Usuario cadastrado com sucesso!");
		
		return new ModelAndView("usuarios/lista");
		
	}
	
}
