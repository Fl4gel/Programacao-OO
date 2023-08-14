package atividade1;

import java.util.Scanner;

public class verificaNumeroPrimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();
        
        int resultado = verificaNumeroPrimo(numero);
        
        if (resultado == 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        scanner.close();
    }
    
    
    /**
     * @param n
     * @return
     */
    public static int verificaNumeroPrimo(Integer n) {
        if (n <= 1) {
            return 0;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        
        return 1;
    }
}
