/*
2. Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área e exiba na tela
    > fórmula: área=lado X lado
*/

import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("informe o tamanho de um dos lados do quadrado: ");
        Integer lado = input.nextInt();

        var area = lado * lado;

        if (area < 100) {
            System.out.printf("O valor da area é: %d cm.\n", area);
        } else {
            System.out.printf("O valor da area é: %d m.\n", area);
        }

        input.close();
    }
}
