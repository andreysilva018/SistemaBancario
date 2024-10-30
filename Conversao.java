package Secundario;

import entidade.Conta;
import java.util.Scanner;

public class Conversao {
    public double Dolarcomprar,qteDolar, qdeDolar, SaldoDolar, SaldoEuro, qteEuro,qdeEuro, Eurocompra, Dolar = 5.47, Euro = 6.07;
    public boolean continuar = true;
    public char pergunta, pergunta2;
    
    public void SomarDolar(double qteDolar, double Dolar){
        qdeDolar = qteDolar * Dolar;
        this.Dolarcomprar += qteDolar * Dolar;
    }
    public void ConversaoDolar(Conta conta){
         conta.Saldo -=  qdeDolar;
    }
    public void SomaEuro(double qteEuro, double Euro){
        qdeEuro = qteEuro * Euro;   
        this.Eurocompra += qteEuro * Euro ;
    }
    public void ConversaoEuro(Conta conta){
        conta.Saldo -= qdeEuro;
    }

    public String toStringSaldoDOLAR(Conta conta){
        return "Saldo: "
        + conta.Saldo 
        + "\n"
        + "Saldo Dólar: " + SaldoDolar;
    }
    public String toStringDadosDolar(){
        return "Valor do Dólar: " 
        + Dolar + "\n"
        + "Quantidade de dólares adquiridos: " 
        + qteDolar + "\n"
        + "Valor a pagar nos dólares: " 
        + qdeDolar;
    }

    public String toStringSaldoEURO(Conta conta){
        return "Saldo: "
        + conta.Saldo
        + "\n"
        + "Saldo Euro: " + SaldoEuro;

    }
    public String toStringDadosEuro (){
        return " " 
        + "Valor do Euro: "
        + Euro + "\n"
        + "Quantidade de Euros adquiridos: "
        + qteEuro + "\n"
        + "Valor a pagar nos euros: " 
        + qdeEuro;
    }

    
    public void TextoDolar(Conta conta, Scanner sc){
        System.out.println("Valor do Dólar: " + Dolar);
        System.out.println("Entre com a quantidade de dólares que deseja converter: ");
        qteDolar = sc.nextDouble();
        SomarDolar(qteDolar, Dolar);
        if(conta.Saldo < qdeDolar){
            System.out.println("\n");
            System.out.println(" *Ops! * ");
            System.out.println("Este valor não pode ser convertido ");
            System.out.println("Saldo insuficiente ");
            System.out.println("Este é o seu saldo: " + conta.Saldo);
            System.out.println("Por favor, inserir uma quantidade de acordo com o seu saldo ");
            System.out.println("* Por favor, tente novamente * ");
            System.out.println("\n");
        }else{
            ConversaoDolar(conta);
            SaldoDolar += qteDolar * Dolar;
            System.out.println("Conversão efetuada com sucesso");
            System.out.println("\n");
            System.out.println(toStringDadosDolar());
            System.out.println(toStringSaldoDOLAR(conta));
        }
    }
    public void TextoEuro(Conta conta, Scanner sc){
        System.out.println("Valor do Euro: " + Euro);
        System.out.println("Entre com a quantidade de euros que deseja converter ");
        qteEuro = sc.nextDouble();
        SomaEuro(qteEuro, Euro);
        if(conta.Saldo < qdeEuro){
            System.out.println("\n");
            System.out.println(" *Ops! * ");
            System.out.println("Este valor não pode ser convertido");
            System.out.println("Saldo insuficiente");
            System.out.println("Este é o seu saldo: " + conta.Saldo);
            System.out.println("Por favor, inserir uma quantidade de acordo com o seu saldo");
            System.out.println(" * Por favor, tente novamente * ");
            System.out.println("\n");
        }else{
        ConversaoEuro(conta);
        SaldoEuro += qteEuro * Euro;
        System.out.println("Conversão efetuada com sucesso");
        System.out.println("\n");
        System.out.println(toStringDadosEuro());
        System.out.println(toStringSaldoEURO(conta));
        }
    }
    
    public void OpcaoInvalida(Conta conta, Scanner sc){
        System.out.println("Opção inválida");
        System.out.println("Deseja recomeçar ? (s/n)");
        pergunta2 = sc.next().charAt(0);    
        if( Character.toLowerCase(pergunta2) == 's'){
            CompraDolar(conta, sc);
            }
    }

    public void PerguntaConverter(Conta conta, Scanner sc){
        //voltar:
        System.out.println("Deseja converter em Dólar($) || Euro(e) || Não(n)");
        pergunta = sc.next().charAt(0);
            switch (pergunta) {
                case '$':
                conta.pergunta = '$';
                    break;
                case 'e':
                continuar = true;
                conta.pergunta = 'e';
                    break;
                case 'n':
                conta.pergunta = 'n';
                    break;
                default:
                OpcaoInvalida(conta, sc);
                    break;
            }
    }

    public void CompraDolar(Conta conta, Scanner sc){
        System.err.println("Deseja converter em Dólar($) ou em Euro(e)");
        conta.pergunta = sc.next().charAt(0);
        while(continuar){
            switch (conta.pergunta){
                case '$':
                TextoDolar(conta, sc);
                PerguntaConverter(conta, sc);
                break;
                case 'e':
                TextoEuro(conta, sc);
                PerguntaConverter(conta, sc);
                break;
                case 'n':
                System.out.println(toStringSaldoDOLAR(conta));
                System.out.println(toStringSaldoEURO(conta));
                continuar = false;
                break;
                default :
                /*Se caso o cliente digitar outra tecla que não seja iguais do cases acima, entrará no default e aparecará a opção inválida e perguntará ao cliente se ele deseja recomeçar a sessão! */
                OpcaoInvalida( conta, sc);
                break;
            }
        }
    }
}