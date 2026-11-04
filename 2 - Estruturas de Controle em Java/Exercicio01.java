/* 
1. Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número;
*/

import java.util.Scanner;

public class Exercicio01 {
    private final static String MENSAGEM = "%d X %d = %d\n";

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.println("Informe um numero: ");
        var numero = input.nextInt();
        System.out.println("=== TABUADA ===");
        for (var i = 0; i <= 10; i++) {
            var resultado = numero * i;
            System.out.printf(MENSAGEM, numero, i, resultado);
        }
        input.close();
    }
}
