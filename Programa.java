import java.util.Locale;
import java.util.Scanner;

import entidade.Dados;


public class Programa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		Dados
		
		double codigo = 123;
		dados.GerarCodigo(codigo);
		int pergunta, Codigo;
		boolean continuar = true;
		
		String conta;
		
		System.out.println("PRIMEIRO TESTE");
		System.out.println("\n Resultado da conta criada: " + conta);
		
		/*System.out.println("-----/ Sistema Bancario /-----/ Criando Conta Bancária /-----");
		while (continuar) {
		System.out.println("Deseja entar com uma conta existente: -- Digite 1 -- " + "Deseja criar uma conta: -- Digite 2 -- " + "\n------/ Sair do Programa: -- Digite 0 -- ");
		pergunta = sc.nextInt();
		sc.nextLine();
			switch (pergunta) {
				case 1:
					System.out.println("Dados conta1: " + dados.toString());
					System.out.println("Digite o número da conta: ");
					Codigo = sc.nextInt();
					//Dados contaexistente = null;
					//if(Codigo == dados.codigo) {
						//contaexistente = dados.;
						System.out.println("Conta existente");
						System.out.println("Dados conta1: " + dados.toString());
					//}else {
						System.out.println("-----/ Conta inexistente /----- ");
					//}
					break;
					
				case 2:
					//dados.CadastrarConta(sc);
					//Dados conta1 = new Dados(name, CPF, codigo);
					//System.out.println("Código da conta: " + conta1.codigo);
					break;
				case 0:
					continuar = false;
					break;
				default:
					System.out.println(" ---------/ ERRO NO PROGRAMA /-----");
			}
		}
		System.out.println("----------/  FIM DO PROGRAMA /----------");*/
		sc.close();
	}
}
