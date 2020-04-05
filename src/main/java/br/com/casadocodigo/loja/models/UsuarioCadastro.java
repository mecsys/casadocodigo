package br.com.casadocodigo.loja.models;

public class UsuarioCadastro extends Usuario {

	private static final long serialVersionUID = 1L;

	private String senhaConfirma;

	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}

	public String getSenhaConfirma() {
		return senhaConfirma;
	}

}
