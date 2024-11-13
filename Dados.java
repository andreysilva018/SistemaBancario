package entidade;

import java.util.Scanner;

public class Dados {
	String name;
	String CPF;
	double codigo = 50;
	
	public Dados (String name, String CPF, double codigo) {
		this.name = name;
		this.CPF = CPF;
		this.codigo = GerarCodigo(codigo);
	}
 
	public double GerarCodigo(double codigo) {
		this.codigo += codigo;
		return codigo++;
	}
	
	public void principal(Scanner sc) {
		System.out.println("Digite seu Nome completo: ");
		String name = sc.nextLine();
		System.out.println("Digite o CPF:");
		String CPF = sc.nextLine();
	}
	
	public Dados CadastrarConta (Scanner sc, Dados dados) {
		System.out.println("Digite seu Nome completo: ");
		String name = sc.nextLine();
		System.out.println("Digite o CPF:");
		String CPF = sc.nextLine();
		Dados conta = new Dados(name, CPF, codigo);
		//Dados conta = new info(name, CPF, codigo);
		System.out.println("Código da conta: " + codigo);
		System.out.println("\nConta Cadastrada com Sucesso\n");
		System.out.println("CONTA CADASTRADA: \n" + dados.toString());
		return conta;
	}
	
	public String toString() {
		return "Nome: " + this.name + "\nCPF: " + this.CPF;
	}
}
