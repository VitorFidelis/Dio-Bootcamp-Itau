/*
 4. Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números, 
 a execução do código irá continuar até que o número informado dividido pelo primeiro número tenha 
 resto diferente de 0 na divisão, números menores que o primeiro número devem ser ignorados;
 */

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        Boolean teste = true;

        System.out.println("Primeiro numero: ");
        int n1 = input.nextInt();

        while (teste) {
            System.out.println("Segundo numero: ");
            int n2 = input.nextInt();

            if (n2 < n1) {
                System.err.println("número menor que o primeiro número informado");
                continue;
            }
            teste = n2 % n1 == 0;
        }
        input.close();
    }
}
