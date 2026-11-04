/*
3. Escreva um código que o usuário entre com um primeiro número, 
um segundo número maior que o primeiro e escolhe entre a opção par e impar, 
com isso o código deve informar todos os números pares ou ímpares (de acordo com a seleção inicial) 
no intervalo de números informados, incluindo os números informados e em ordem decrescente;
*/

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Primeiro numero: ");
        var primieroNumero = input.nextInt();
        System.out.println("segundo numero: ");
        var segundoNumero = input.nextInt();

        if (segundoNumero > primieroNumero) {
            System.out.println("PAR ou IMPAR: ?");
            var parOrImpar = input.next();

            int restoEsperado = parOrImpar.equalsIgnoreCase("PAR") ? 0 : 1;

            for (int i = segundoNumero; i >= primieroNumero; i--) {
                if (Math.abs(i % 2) == restoEsperado) {
                    System.out.println(i);
                }
            }
        } else {
            System.err.println("O segundo NUMERO não é maior que o primeiro.");
        }

        input.close();
    }
}
