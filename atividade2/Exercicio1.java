package Exercicio1;

import java.util.Scanner;

 abstract  class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double n1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double n2 = scanner.nextDouble();

        System.out.print("Digite a operação (+, -, *, /): ");
        char operacao = scanner.next().charAt(0);

        double resultado = 0.0;

        switch (operacao) {
            case '+':
                resultado = n1 + n2;
                break;
            case '-':
                resultado = n1 - n2;
                break;
            case '*':
                resultado = n1 * n2;
                break;
            case '/':
                if (n2 != 0) {
                    resultado = n1 / n2;
                } else {
                    System.out.println("System error");
                    System.exit(1); 
                break;
             }
            default:
                System.out.println("System error ");
                System.exit(1);
        }

        System.out.println("Resultado: " + resultado);

        scanner.close();
    }
}
