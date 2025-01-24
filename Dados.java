package entidade;

import java.util.Scanner;

public class Dados {
	public String name;
	public String CPF;
	public int codigo;
	public double saldo;
	
	private static int contador = 1;
	
	public Dados (String name, String CPF) {
		this.name = name;
		this.CPF = CPF;
		this.codigo = contador++;
	}
	public Dados() {}
	
	public void Deposito (Scanner sc, Dados dados) {
		Dados contaExistente;
		System.out.println("Digite o valor do deposito: ");
		double valor = sc.nextDouble();
		try {
			if (valor > 0 ) {
				System.out.println("Déposito realizado com sucesso!\n" + "Novo saldo na conta" );
				toString();
				} else {
				System.out.println("O valor do deposito deve ser positivo");
				}
			} 
			catch (Exception e) {
			System.out.println("Erro ao processar o deposito.");
			System.out.println("Certifique que digitou um valor válido e tente novamente");
			sc.nextLine();
			}
		this.saldo += valor;
	}
	public String toString() {
		return "Nome: " + name +
				"\nCPF: " + CPF + 
				"\nCódigo da conta: " + codigo +
				"\nSaldo : R$" + saldo;
	}
}
