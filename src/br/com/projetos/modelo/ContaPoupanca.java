package br.com.projetos.modelo;

import br.com.projetos.exceptions.ValoresException;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {		
	}

	public ContaPoupanca(String conta, String agencia, Cliente cliente) {
		super(conta, agencia, cliente);
	}

	public ContaPoupanca(Double saldo, String conta, String agencia, Cliente cliente) {
		super(saldo, conta, agencia, cliente);
		if(this.saldo < 0) {
			throw new ValoresException("\nInforme um valor válido!");
		}
	}

	@Override
	public void sacar(Double valor) {
		if(valor <= 0) {
			throw new ValoresException("0 valor precisa ser maior que zero!");
		}
		if(valor > this.saldo) {
			throw new ValoresException("0 valor ultrapassa o saldo da conta!");
		}
		this.saldo -= valor + 1.0;
	}
	
	@Override
	public void imprimirRecibo() {
		super.imprimirRecibo();
	}
}
