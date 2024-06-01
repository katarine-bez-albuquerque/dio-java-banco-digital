package br.com.projetos.aplicacao;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import br.com.projetos.exceptions.ValoresException;
import br.com.projetos.modelo.ContaCorrente;
import br.com.projetos.modelo.ContaPoupanca;
import br.com.projetos.modelo.PessoaFisica;
import br.com.projetos.modelo.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		String opcao;
		double valor = 0;
		
		PessoaFisica pessoaFisica = null;
		PessoaJuridica pessoaJuridica = null;
		ContaCorrente contaCorrente = null;
		ContaPoupanca contaPoupanca = null;
		
		System.out.println("Banco Digital:\n");
		
		try {
			
			System.out.print("Digite seu nome: ");
			String nome = sc.nextLine().toUpperCase();
			
			escolhaCliente();
			System.out.print("Digite uma opção: ");
			opcao = sc.nextLine();
			
			switch(opcao) {
				case "1": {
					escolherPessoaFisica(nome, opcao, sc, valor, pessoaFisica, contaPoupanca, contaCorrente);
					break;
				}
				case "2": {
					escolherPessoaJuridica(nome, opcao, sc, valor, pessoaJuridica, contaPoupanca, contaCorrente);
					break;
				}
				default: { 
					System.err.println("\nOpção inválida! Tente novamente.");
					break;				
				}
			}
		}
		catch (ValoresException e) {
			 System.err.println("\n" + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.err.println("Informe somente valores numérios!");
		}
		sc.close();
	}
	
	public static void escolhaCliente() {
		System.out.println("\n1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurídica\n");		
	}
	
	public static void escolhaConta() {
		System.out.println("\n1 - Conta Poupança");
		System.out.println("2 - Conta Corrente\n");		
	}
	
	public static void escolhaServico() {
		System.out.println("\n1 - Consultar Saldo");
		System.out.println("2 - Depósito");
		System.out.println("3 - Saque");
		System.out.println("4 - Transferência");
		System.out.println("5 - Encerrar Conta\n");
	}
		
	public static void escolherPessoaFisica(String nome, String opcao, Scanner sc, Double valor, PessoaFisica pessoaFisica, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente) {
		System.out.print("\nDigite seu CPF: ");
		String cpf = sc.nextLine();
		pessoaFisica = new PessoaFisica(nome, cpf);
		
		escolhaConta();
		System.out.print("Digite uma opção: ");
		opcao = sc.nextLine();
		
		switch(opcao) {
			case "1": {
				System.out.print("\nDigite um valor para depósito inicial: ");
				valor = sc.nextDouble();
				sc.nextLine();
				
				contaPoupanca = new ContaPoupanca(valor, "123456", "P025", pessoaFisica);
				contaCorrente = new ContaCorrente(valor, "123456", "C025", pessoaFisica);
				
				pessoaFisica.abrirConta(contaPoupanca);
				
				escolhaServico();
				System.out.print("Digite uma opção: ");
				opcao = sc.nextLine();
				
				escolherContaPoupancaPessoaFisica(opcao, sc, valor, pessoaFisica, contaPoupanca, contaCorrente);
															
				break;
			}
			case "2": {
				
				System.out.print("\nDigite um valor para depósito inicial: ");
				valor = sc.nextDouble();
				sc.nextLine();
				
				contaPoupanca = new ContaPoupanca(valor, "789112", "P025", pessoaFisica);
				contaCorrente = new ContaCorrente(valor, "789112", "C025", pessoaFisica);
				
				pessoaFisica.abrirConta(contaCorrente);
				
				escolhaServico();
				System.out.print("Digite uma opção: ");
				opcao = sc.nextLine();
				
				escolherContaCorrentePessoaFisica(opcao, sc, valor, pessoaFisica, contaPoupanca, contaCorrente);
				
				break;
			}
			default: {
				System.err.println("\nOpção inválida! Tente novamente.");
				break;				
			}
		}
		pessoaFisica.exibirContas();
	}
	
	public static void escolherPessoaJuridica(String nome, String opcao, Scanner sc, Double valor, PessoaJuridica pessoaJuridica, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente) {
		System.out.print("\nDigite seu CNPJ: ");
		String cnpj = sc.nextLine();
		pessoaJuridica = new PessoaJuridica(nome, cnpj);
		
		escolhaConta();
		System.out.print("Digite uma opção: ");
		opcao = sc.nextLine();
		
		switch(opcao) {
			case "1": {
				
				System.out.print("\nDigite um valor para depósito inicial: ");
				valor = sc.nextDouble();
				sc.nextLine();
				
				contaPoupanca = new ContaPoupanca(valor, "123456", "P025", pessoaJuridica);
				contaCorrente = new ContaCorrente(valor, "123456", "C025", pessoaJuridica);
				
				pessoaJuridica.abrirConta(contaPoupanca);
				
				escolhaServico();
				System.out.print("Digite uma opção: ");
				opcao = sc.nextLine();

				escolherContaPoupancaPessoaJuridica(opcao, sc, valor, pessoaJuridica, contaPoupanca, contaCorrente);
				
				break;
			}
			case "2": {
				
				System.out.print("\nDigite um valor para depósito inicial: ");
				valor = sc.nextDouble();
				sc.nextLine();
				
				contaPoupanca = new ContaPoupanca(valor, "789112", "P025", pessoaJuridica);
				contaCorrente = new ContaCorrente(valor, "789112", "C025", pessoaJuridica);
				
				pessoaJuridica.abrirConta(contaCorrente);
				
				escolhaServico();
				System.out.print("Digite uma opção: ");
				opcao = sc.nextLine();
				
				escolherContaCorrentePessoaJuridica(opcao, sc, valor, pessoaJuridica, contaPoupanca, contaCorrente);
				
				break;
			}						
			default: { 
				System.err.println("\nOpção inválida! Tente novamente.");
				break;				
			}
		}
		pessoaJuridica.exibirContas();
	}
	
	public static void escolherContaPoupancaPessoaFisica(String opcao, Scanner sc, Double valor, PessoaFisica pessoaFisica, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente) {
		switch(opcao) {
			case "1": {
				System.out.println(String.format("\nR$ %.2f",contaPoupanca.getSaldo()));				
				break;
			}
			case "2": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaPoupanca.depositar(valor);
				break;
			}
			case "3": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaPoupanca.sacar(valor);
				break;
			}
			case "4": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				
				contaPoupanca.transferir(valor,contaCorrente);
				break;
			}
			case "5": {
				if(contaPoupanca.getSaldo() > 0) {
					System.err.println("Verificar saldo da conta antes de encerrar!");
					break;
				}
				pessoaFisica.encerrarConta(contaPoupanca);
				System.out.println("\nConta encerrada!");
				break;
			}
			default: { 
				System.err.println("\nOpção inválida! Tente novamente.");
				break;				
			}
		}
	}
	
	public static void escolherContaCorrentePessoaFisica(String opcao, Scanner sc, Double valor, PessoaFisica pessoaFisica, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente) {
		switch(opcao) {
			case "1": {
				System.out.println(String.format("\nR$ %.2f",contaCorrente.getSaldo()));				
				break;
			}
			case "2": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaCorrente.depositar(valor);
				break;
			}
			case "3": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaCorrente.sacar(valor);
				break;
			}
			case "4": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();				
				contaCorrente.transferir(valor,contaPoupanca);
				break;
			}
			case "5": {
				if(contaCorrente.getSaldo() > 0) {
					System.err.println("Verificar saldo da conta antes de encerrar!");
					break;
				}
				pessoaFisica.encerrarConta(contaCorrente);
				System.out.println("\nConta encerrada!");
				break;
			}
			default: { 
				System.err.println("\nOpção inválida! Tente novamente.");
				break;				
			}
		}
	}
	
	public static void escolherContaPoupancaPessoaJuridica(String opcao, Scanner sc, Double valor, PessoaJuridica pessoaJuridica, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente) {
		switch(opcao) {
			case "1": {
				System.out.println(String.format("\nR$ %.2f",contaPoupanca.getSaldo()));				
				break;
			}
			case "2": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaPoupanca.depositar(valor);
				break;
			}
			case "3": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaPoupanca.sacar(valor);
				break;
			}
			case "4": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();						
				contaPoupanca.transferir(valor,contaCorrente);
				break;
			}
			case "5": {
				if(contaPoupanca.getSaldo() > 0) {
					System.err.println("Verificar saldo da conta antes de encerrar!");
					break;
				}
				pessoaJuridica.encerrarConta(contaPoupanca);
				System.out.println("\nConta encerrada!");
				break;
			}
			default: { 
				System.err.println("\nOpção inválida! Tente novamente.");
				break;				
			}
		}
	}
	
	public static void escolherContaCorrentePessoaJuridica(String opcao, Scanner sc, Double valor, PessoaJuridica pessoaJuridica, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente) {
		switch(opcao) {
			case "1": {
				System.out.println(String.format("\nR$ %.2f",contaCorrente.getSaldo()));				
				break;
			}
			case "2": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaCorrente.depositar(valor);
				break;
			}
			case "3": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();
				contaCorrente.sacar(valor);
				break;
			}
			case "4": {
				System.out.print("\nDigite o valor: ");
				valor = sc.nextDouble();						
				contaCorrente.transferir(valor,contaPoupanca);
				break;
			}
			case "5": {
				if(contaCorrente.getSaldo() > 0) {
					System.err.println("Verificar saldo da conta antes de encerrar!");
					break;
				}
				pessoaJuridica.encerrarConta(contaCorrente);
				System.out.println("\nConta encerrada!");						
				break;
			}
			default: { 
				System.err.println("\nOpção inválida! Tente novamente.");
				break;				
			}
		}
	}
}
