package br.com.Locadora.model;

public class CPFCNPJInvalidException extends RuntimeException {

	private static final long serialVersionUID = 4494055546451178690L;

	public CPFCNPJInvalidException(String mensagem) {
		super(mensagem);
	}
	
}
