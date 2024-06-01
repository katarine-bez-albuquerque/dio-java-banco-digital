package br.com.projetos.modelo;

import br.com.projetos.exceptions.ValoresException;

public abstract class Conta {
	protected Double saldo;
	protected String conta;
	protected String agencia;
	protected Cliente cliente;
		
	public Conta() {
	}

	public Conta(Double saldo, String conta, String agencia, Cliente cliente) {
		this.saldo = saldo;
		this.conta = conta;
		this.agencia = agencia;
		this.cliente = cliente;
	}
	
	public Conta(String conta, String agencia, Cliente cliente) {		
		this.conta = conta;
		this.agencia = agencia;
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void depositar(Double valor) {
		if(valor <= 0) {
			throw new ValoresException("0 valor precisa ser maior que zero!");
		}
		this.saldo += valor;
	}
	
	public void sacar(Double valor) {
		if(valor <= 0) {
			throw new ValoresException("0 valor precisa ser maior que zero!");
		}
		if(valor > this.saldo) {
			throw new ValoresException("0 valor ultrapassa o saldo da conta!");
		}
		this.saldo -= valor;
	}
	
	public void transferir(Double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public void imprimirRecibo() {
		System.out.println("\n----------//----------");
		System.out.println("\nRECIBO:\n");
		System.out.println("Nome: " + this.cliente.getNome());
		System.out.println("Agência: " + (this.agencia != null ? this.agencia : ""));
		System.out.println("Conta: " + (this.conta != null ? this.conta : ""));
		System.out.println("Saldo: " + (this.saldo > 0 ? String.format("R$ %.2f",this.saldo) : 0));
		System.out.println("\n----------//----------");
	}
}
