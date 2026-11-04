/*
2. Escreva um código onde o usuário entra com sua altura e peso, seja feito o calculo do seu IMC(IMC = peso/(altura * altura)) e seja exibida a mensagem de acordo com o resultado:

- Se for menor ou igual a 18,5 "Abaixo do peso";
- se for entre 18,6 e 24,9 "Peso ideal";
- e for entre 25,0 e 29,9 "Levemente acima do peso";
- Se for entre 30,0 e 34,9 "Obesidade Grau I";
- Se for entre 35,0 e 39,9 "Obesidade Grau II (Severa)";
- Se for maior ou igual a 40,0 "Obesidade III (Mórbida)";
*/

import java.util.Scanner;

public class Exercicio02 {
    private final static String MENSGEM_APRESENTACAO = "=== CALCULADORE DE IMC ===";

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.err.println(MENSGEM_APRESENTACAO);

        System.out.println("Altura: ");
        var altura = input.nextDouble();
        System.out.println("Peso: ");
        var peso = input.nextDouble();

        Double calcImc = (peso / (altura * altura));

        System.out.printf("SEU IMC: %.2f kg/m²\n", calcImc);

        if (calcImc < 18.5) {
            System.out.println("Abaixo do peso.");
        } else if (calcImc < 25.0) {
            System.out.println("Peso ideal.");
        } else if (calcImc < 30.0) {
            System.out.println("Levemente acima do peso.");
        } else if (calcImc < 35.0) {
            System.out.println("Obesidade Grau I.");
        } else if (calcImc < 40.0) {
            System.out.println("Obesidade Grau II (Severa).");
        } else {
            System.out.println("Obesidade III (Mórbida).");
        }

        input.close();
    }
}
