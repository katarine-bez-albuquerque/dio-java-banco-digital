package br.com.projetos.exceptions;

public class ValoresException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValoresException(String mensagem) {
		super(mensagem);
	}
}
