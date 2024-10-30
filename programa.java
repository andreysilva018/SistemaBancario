package Principal;

import entidade.Conta;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

class infoConta {
    int numeroConta ;
    String nome;

    public infoConta (int numeroConta,String nome){
        this.numeroConta = numeroConta;
        // this.CPF = CPF;
        this.nome = nome;
    }
}

public class programa {
    private static final Random random = new Random();
    private static final int NUMERO_CONTA_MIN = 1000; // Limite inferior
    private static final int NUMERO_CONTA_MAX = 9999;
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Conta c = new Conta();
        ArrayList<infoConta> contas = new ArrayList<>();
        int escolha;
        boolean continuar = true;

        while (continuar) {
        System.out.println("1. Criar uma nova conta ");
        System.out.println("2. Entrar em uma conta já existente ");
        System.out.println("3. Sair ");
        escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("CRIAÇÃO DE CONTA");
                    System.out.println("Entre com o nome completo:");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    int numeroConta = gerarNumeroConta(contas);
                    infoConta novaConta = new infoConta(numeroConta, nome);
                    contas.add(novaConta);
                    System.out.println("\nConta criada com sucesso! \n");
                    System.out.println("Nome do titular da conta: " + novaConta.nome + "\n" + "Número da conta: " + novaConta.numeroConta);
                    System.out.println("\n");
                break;
                case 2:
                sc.nextLine();
                System.out.println("Digite o número da conta: ");
                numeroConta = sc.nextInt();
                infoConta contaEncontrada = null;

                // Verifica se o nome da conta já existe
                for (infoConta conta : contas ) {
                    if (conta.numeroConta == numeroConta) {
                        contaEncontrada = conta;
                    }
                     if (contaEncontrada != null) {
                        System.out.println("Bem vindo, " + contaEncontrada.nome + "\n");
                        continuar = false;
                    }else {
                        System.out.println("Conta não encontrada! \n");
                    }
                }
                break;
                case 3:
                    System.out.println("sair");
                    System.out.println(" '   FIM DO PROGRAMA -_-   ' ");
                    continuar = false;
                break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        
        
        // new Transacao().DadosTitular(info, sc);        
        // new Transacao().continuar = true;
        new Transacao().CasoPergunta1(c, sc);

        // new Secundario.Conversao().CompraDolar(c, sc);
        sc.close();
    }
     private static int gerarNumeroConta(ArrayList<infoConta> contas) {
         int numeroConta;
         boolean existe;
    
         do {
             numeroConta = NUMERO_CONTA_MIN + random.nextInt(NUMERO_CONTA_MAX - NUMERO_CONTA_MIN + 1);
             existe = false;
    
             // Verifica se o número da conta já existe
             for (infoConta conta : contas) {
                 if (conta.numeroConta == numeroConta) {
                     existe = true;
                     break;
                 }
             }
         } while (existe); // Continua gerando até encontrar um número único
    
         return numeroConta;
     }
}