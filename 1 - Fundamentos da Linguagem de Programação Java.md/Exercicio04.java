/*
4. Escreva um código que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio04 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Usuario> teste = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {

            System.out.println("NOME:");
            String nome = input.next();

            System.out.println("IDADE: ");
            int idade = input.nextInt();

            Usuario usuario = new Usuario(nome, idade);

            teste.add(usuario);
        }

        for (Usuario pessoa : teste) {
            
            int diferenca = teste.get(0).idade - teste.get(1).idade;
            System.out.printf("NOME: %s | IDADE: %s | Diferenca: %d\n", pessoa.getNome(), pessoa.getIdade(), diferenca);

        }

        input.close();
    }

    public static class Usuario {
        private String nome;
        private int idade;

        public Usuario(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

    }
}
