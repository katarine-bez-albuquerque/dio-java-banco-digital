package br.com.projetos.modelo;

public class PessoaJuridica extends Cliente {

	private String cnpj;

	public PessoaJuridica() {		
	}

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
