/*
3. Escreva um código que receba a base e a alturade de um retângulo, calcule sua área e exiba na tela
    > fórmula: área=base X altura
*/

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o valor da base do retângulo: ");
        var base = input.nextInt();

        System.out.println("Informe o valor da altura do retângulo: ");
        var altura = input.nextInt();

        var area = base * altura;

        if (area < 100) {
            System.out.printf("Resposata | base: %d X altura: %d = area: %d cm\n", base, altura, area);
        } else {
            System.out.printf("Resposata | base: %d X altura: %d = area: %d m\n", base, altura, area);
        }

        input.close();
    }
}
