package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha",
				"menu.usuarios.required.senha", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senhaConfirma",
				"menu.usuarios.required.senhaConfirma", "Field name is required.");

		Usuario usuario = (Usuario) target;
		
		if(usuario.getSenha().length() < 5) {
			errors.rejectValue("senha", "menu.usuarios.senha.tamanho");
		}
		
		if(!(usuario.getSenha().equals(usuario.getSenhaConfirma()))){
			errors.rejectValue("senhaConfirma", "menu.usuarios.notmatch.senhas");
		}
		
	}

}