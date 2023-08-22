package Exercicio2;

import java.util.Scanner;

 abstract class ConversorTemperatura {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Você vai inserir em Celsius(c) ou Farenheit(f): ");
        char TipoTemp = scanner.next().charAt(0);

        System.out.print("Digite o numero a ser convertido: ");
        double n1 = scanner.nextInt();

        double resultado = 0.0;

        switch (TipoTemp) {
            case 'c':
                resultado = (n1 * 1.8) + 32;
                break;
            case 'f':
                resultado = (n1 - 32) / 1.8 ;
                break;

            default:
                System.out.println("System error ");
                System.exit(1);
        }

        System.out.println("Resultado: " + resultado);

        scanner.close();
    }
}
