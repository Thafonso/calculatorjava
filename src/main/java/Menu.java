import java.util.Scanner;

public class Menu {
    private final Scanner in = new Scanner(System.in); //Deixa o objeto privado parea dentro da classe
    private final Calculadora calculadora = new Calculadora();

    public void exibirMenu () {
        int opcao = -1;
        while (opcao != 0) {
            mostrarOpcoes();
            System.out.println("Escolha uma das opções");
            if (in.hasNextInt()){
                opcao = in.nextInt();
                if (opcao == 0){
                    System.out.println("Encerrando programa...");
                    break;
                }
                if (opcao <1 || opcao >4) {
                    System.out.println("Opção invalida, tente novamente");
                    continue;
                }
                System.out.println("Digite o primeiro numero: ");
                double num1 = in.nextDouble();

                System.out.println("Digite o segundo numero: ");
                double num2 = in.nextDouble();

                double resultado = executarOperacao(opcao, num1, num2);
                System.out.println("o resultado da operação é: " + resultado);
                in.next();
            }
        }
        in.close();
    }

    private void mostrarOpcoes(){
        System.out.println("==== Calculadora dos 7 mares ====");
        System.out.println("Selecione uma das opções abaixo");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("0 - Sair");
    }

    private double executarOperacao(int opcao, double num1, double num2){
        return switch (opcao){
            case 1 -> calculadora.soma(num1, num2);
            case 2 -> calculadora.subtracao(num1, num2);
            case 3 -> calculadora.multiplicacao(num1, num2);
            case 4 -> calculadora.divisao(num1, num2);
            default -> throw new IllegalArgumentException("Opção invalida");
        };
    }
}
