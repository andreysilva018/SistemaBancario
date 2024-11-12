import java.util.Locale;
import java.util.Scanner;

class Dados {
	String name;
	String CPF;
	double codigo = 50;
	
	public Dados(String name, String CPF, double codigo) {
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
	
	public void CadastrarConta (Scanner sc) {
		System.out.println("Digite seu Nome completo: ");
		String name = sc.nextLine();
		System.out.println("Digite o CPF:");
		String CPF = sc.nextLine();
		Dados conta1 = new Dados(name, CPF, codigo);
		System.out.println("Código da conta: " + codigo);
		System.out.println("\nConta Cadastrada com Sucesso\n");
		System.out.println("CONTA CADASTRADA: \n");
	}
	public String toString() {
		return "Nome: " + this.name + "\nCPF: " + this.CPF;
	}
}
public class Programa {
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		Dados dados = new Dados(null, null, 50);
		double codigo = 123;
		dados.GerarCodigo(codigo);
		int pergunta, Codigo;
		boolean continuar = true;
		
		
		System.out.println("-----/ Sistema Bancario /-----/ Criando Conta Bancária /-----");
		while (continuar) {
		System.out.println("Deseja entar com uma conta existente: -- Digite 1 -- " + "\nDeseja criar uma conta: -- Digite 2 -- " + "\nSair do Programa: -- Digite 0 -- ");
		pergunta = sc.nextInt();
		sc.nextLine();
			switch (pergunta) {
				case 1:
					System.out.println("Digite o número da conta: ");
					Codigo = sc.nextInt();
					System.out.println("Codigo da classe separada: " + dados.codigo);
					if(Codigo == dados.codigo) {
						System.out.println("Conta existente");
					}else {
						System.out.println("-----/ Conta inexistente /----- ");
					}
					break;
					
				case 2:
					dados.CadastrarConta(sc);
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
		System.out.println("----------/  FIM DO PROGRAMA /----------");
		sc.close();
	}
}
