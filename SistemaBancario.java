import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Conta {
    String nome;
    int numeroConta; // Este será o ID da conta

    public Conta(String nome, int numeroConta) {
        this.nome = nome;
        this.numeroConta = numeroConta;
    }

    // Métodos para adicionar, retirar e mostrar saldo aqui
}

public class SistemaBancario {
    private static final Random random = new Random();
    private static final int NUMERO_CONTA_MIN = 1000; // Limite inferior
    private static final int NUMERO_CONTA_MAX = 9999; // Limite superior

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        while (true) {
            System.out.println("1. Criar nova conta");
            System.out.println("2. Acessar conta existente");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                // Criação de nova conta
                System.out.print("Nome: ");
                String nome = scanner.next();

                // Gera um número de conta único
                int numeroConta = gerarNumeroConta(contas);

                Conta novaConta = new Conta(nome, numeroConta);
                contas.add(novaConta);
                System.out.println("Conta criada com sucesso! Número da conta: " + numeroConta);
            } else if (escolha == 2) {
                // Acessar conta existente
                System.out.print("Digite o número da conta: ");
                int numeroConta = scanner.nextInt();

                Conta contaEncontrada = null;
                for (Conta conta : contas) {
                    if (conta.numeroConta == numeroConta) {
                        contaEncontrada = conta;
                        break;
                    }
                }

                if (contaEncontrada != null) {
                    System.out.println("Bem-vindo, " + contaEncontrada.nome);
                    // Aqui você pode permitir retiradas, depósitos, etc.
                } else {
                    System.out.println("Conta não encontrada!");
                }
            } else if (escolha == 3) {
                break;
            }
        }
        scanner.close(); // É sempre bom fechar o scanner
    }

    private static int gerarNumeroConta(ArrayList<Conta> contas) {
        int numeroConta;
        boolean existe;

        do {
            numeroConta = NUMERO_CONTA_MIN + random.nextInt(NUMERO_CONTA_MAX - NUMERO_CONTA_MIN + 1);
            existe = false;

            // Verifica se o número da conta já existe
            for (Conta conta : contas) {
                if (conta.numeroConta == numeroConta) {
                    existe = true;
                    break;
                }
            }
        } while (existe); // Continua gerando até encontrar um número único

        return numeroConta;
    }
}
