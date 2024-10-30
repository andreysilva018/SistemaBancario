package entidade;

public class Conta {
    public String nome;
    public int id;
    public double Saldo;
    public double depositoNovo;
    public double depositoRetirado;
    public char pergunta;


    // public void escolha(infoConta info, Scanner sc){
    //     int escolha;
    //     System.out.println("1. Criar uma nova conta ");
    //     System.out.println("2. Entrar em uma conta já existente ");
    //     System.out.println("3. Sair ");
    //     escolha = sc.nextInt();
    //     switch (escolha){
    //         case 1:
    //         System.out.println("é isso");
    //         break;
    //         case 2:
    //         DadosTitular(info, sc);
    //         break;
    //         case 3:
    //         System.out.println("sair");
    //         break;
    //         default:
    //         System.out.println("Opção inválida");
    //         break;
    //     }
    // }

    //  public void DadosTitular(infoConta info, Scanner sc){
    //     System.out.println(" Entre com o número da conta: ");
    //     info.id = sc.nextInt();
    //     System.out.println("");
    //     System.out.println("Entre com o nome: ");
    //     info.nome = sc.nextLine();
    //     System.out.println("");
    // }

    public void Adicionadeposito(double depositoNovo, double Saldo){
        this.Saldo = Saldo + depositoNovo; 
    }
    /* "Adicionadeposito"
     Se caso o titular da conta desejar fazer um deposito novo, tem que somar o deposito inicial mais o deposito novo.
     */

    public void Subtrairdeposito(double depositoRetirado, double Saldo){
        this.Saldo = Saldo - depositoRetirado;
    }
    /* "Subtrairdeposito" 
     Se caso o titulat da conta desejar retirar algum valor da conta, tem que subtrair o deposito Inicial menos o deposito Retirado.
    */

    // /* "toString"  POSSUI OS DADOS DA CONTA, NOME DO TITULAR, ID DA CONTA E SALDO DA CONTA */
    public String toString(Conta c ){
     return 
      "Número da conta: " +
      "" + c.id + "\n"
      + "Titular da conta: "
      + "" + c.nome + "\n"
      + "Saldo da conta: R$"
      + Saldo
      + "\n";
    }
}