package br.com.projetos.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	protected String nome;
	private List<Conta> contas; 

	public Cliente() {		
	}

	public Cliente(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void abrirConta(Conta conta) {
		contas.add(conta);
	}
	
	public void encerrarConta(Conta conta) {
		contas.remove(conta);
	}
	
	public void exibirContas() {
		if(contas.size() < 0) {
			System.out.println("Não há contas cadastradas!");
		}
		else {
			for(Conta c : contas) {
				c.imprimirRecibo();
			}
		}
	}
}
