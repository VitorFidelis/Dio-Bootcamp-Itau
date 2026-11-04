/*
1. Escreva um código que receba o nome e o ano de nascimento de alguém e 
    imprima na tela a seguinte mensagem: "Olá 'Fulano' você tem 'X' anos"
*/

import java.time.LocalDate;
import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("informe o seu nome: ");
        String nome = input.next();

        System.out.println("informe o ano em que voce nasceu: ");
        Integer anoNascimento = input.nextInt();

        int anoAtual = LocalDate.now().getYear();

        var idade = anoAtual - anoNascimento;   

        System.out.printf("Olá %s, voce tem %d \n ", nome, idade );

        input.close();
    }
}
