import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import entidade.Dados;


public class Programa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		LocalDate d01 = LocalDate.now();
		Dados dados = new Dados();
		Dados[] contas = new Dados[100];
	
		int pergunta, perguntaCodigo, indice = 0;
		char Pergunta;
		
		System.out.println("-----/ Sistema Bancario /-----/ Criando Conta Bancária /-----");
		/*System.out.println("Deseja entar com uma conta existente: -- Digite 1 -- " + "Deseja criar uma conta: -- Digite 2 -- " + "\n------/ Sair do Programa: -- Digite 0 -- ");
		pergunta = sc.nextInt();
		sc.nextLine();*/
		while(true) {
			System.out.println("Digite seu nome: ");
			String name = sc.nextLine();
			while(!name.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
				System.out.println("Nome inválido");
				System.out.println("Digite um novamente (com apenas letras e espaços): ");
				name = sc.nextLine();
			}
			System.out.println("Digite seu CPF: ");
			String CPF = sc.nextLine();
			while(!CPF.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
				System.out.println("CPF inválido.");
				System.out.println("Digite novamente no formato correto (000.000.000-00): ");
				CPF = sc.nextLine();
			}
			
			contas[indice] = new Dados(name, CPF);
			indice++;
			
			System.out.println("Deseja criar outra conta ? s/n");
			if(sc.nextLine().equalsIgnoreCase("n")) {
				break;
			}
		}
		for(int i = 0; i <indice; i++) {
			System.out.println("\nConta criada: " + d01);
			System.out.println(contas[i]);
		}
		boolean continuar = true;
		while(continuar) {
			System.out.println("\n" + "\nDigite o codigo da conta ou digite '0' para sair do Programa");
			perguntaCodigo = sc.nextInt();
			sc.nextLine();
			
			if(perguntaCodigo == 0) {
				break;
			}
			Dados contaExistente = null;
			for(int i = 0; i < indice; i++) {
				if(perguntaCodigo == contas[i].codigo) {
					contaExistente = contas[i];
					break;
					}
				}
				if (contaExistente != null) {
					System.out.println("*Conta encontrada*\n" + "\n" + "BEM VINDO "  + "\n" + contaExistente);
					/*System.out.println("CPF: " + contaExistente.CPF + "\nCódigo: " + contaExistente.codigo);
					System.out.println("Saldo R$ " + dados.saldo);*/
					System.out.println("Deseja encerrar o prgrama ou fazer o primeiro deposito ? \n" + "'X' = Encerarr programa || Depositar 'D'");
					Pergunta = sc.next().toUpperCase().charAt(0);
					switch (Pergunta) {
					case 'X': 
						System.out.println("Aguarde, o programa será encerrado");
						perguntaCodigo = 0;
						continuar = false;
						break;
					
					case 'D':
						dados.Deposito(sc, dados);
					}
				}
				else{
					System.out.println("Código inexistente. Tente novamente.");	
				}
		}
		System.out.println("/-----------------/ FIM DO PROGRAMA /-------------------/");
		sc.close();
	}
}