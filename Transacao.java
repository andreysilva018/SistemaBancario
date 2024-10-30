package Principal;

import entidade.Conta;
import java.util.Scanner;

public class Transacao {
    public boolean continuar = true;
    // public char pergunta2;

    // public void DadosTitular(infoConta info, Scanner sc){
    //     System.out.println("Deseja criar uma conta: (S/N)");
    //     pergunta2 = sc.next().charAt(0);
    //     System.out.println(" Entre com o número da conta: ");
    //     info.id = sc.nextInt();
    //     System.out.println("");
    //     System.out.println("Entre com o nome: ");
    //     info.nome = sc.nextLine();
    //     System.out.println("");
    // }
   
    public void AddDeposito(Conta conta, Scanner sc){
        System.out.println("entre com o deposito Novo: ");
            conta.depositoNovo = sc.nextDouble();
            conta.Adicionadeposito(conta.depositoNovo, conta.Saldo);
            System.out.println("");
            System.out.println(conta.toString());
    }
    public void RemovedDeposito(Conta conta, Scanner sc){
        System.out.println("Entre com o valor retirado: ");
        conta.depositoRetirado = sc.nextDouble();
        conta.Subtrairdeposito(conta.depositoRetirado, conta.Saldo);
        System.out.println("");
        System.out.println(conta.toString());
    }
    
    public void OpcaoInvalida(Conta c, Scanner sc){
        System.out.println(" *Opção inválida*\n ");
        System.out.println(" *Deseja recomeçar ?* (S/N)");
        char perguntaErro = sc.next().charAt(0);
            if( Character.toLowerCase(perguntaErro) == 's'){
                CasoPergunta1(c, sc);
            }
    }

   /*public void CasoPergunta2(Conta c, Scanner sc){
        System.out.println("Deseja finalizar a movimentação");
        pergunta2 = sc.next().charAt(0);
        switch (pergunta2){
            case 'S':
        }
        if(Character.toUpperCase(pergunta2) == 'S'){
            continuar = false;
        }else if (Character.toUpperCase(pergunta2) == 'n'){
            System.out.println("Deseja 'Adicionar(A) || 'Retirar(R)' algum valor: ");
            if (Character.toUpperCase(c.pergunta) == 'A'){
                c.pergunta = 'A';
            }else if(Character.toUpperCase(c.pergunta) == 'R'){
                c.pergunta = 'R';
            }
        }
    }*/

    public void CasoPergunta1(Conta c, Scanner sc){
        while(continuar){
        System.out.println("Deseja fazer alguma movimentação na conta: 'Adicionar(A)' || 'Retirar(R)' || 'Não(N)' ");
        c.pergunta = sc.next().charAt(0);
            switch(Character.toUpperCase(c.pergunta)){
                case 'A':
                    AddDeposito(c, sc);
                    CasoPergunta1(c, sc);
                        break;
                case 'R':
                    RemovedDeposito(c, sc); 
                    CasoPergunta1(c, sc);
                        break;
                case 'N':
                    System.out.println(c.toString());
                    continuar = false;
                    break;
                default:
                    /*Se caso o cliente digitar outra tecla que não seja iguais do cases acima, entrará no default e aparecará a opção inválida e perguntará ao cliente se ele deseja recomeçar a sessão! */
                    OpcaoInvalida(c, sc);
                    break;
            }
        }
    }
}