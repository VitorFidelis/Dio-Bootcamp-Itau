package Desafios01;
/*
Desafio
Em um banco digital, a equipe de atendimento esta treinando novos desenvolvedores para automatizar verificacoes simples antes de liberar operacoes no sistema interno. Uma das primeiras tarefas e validar se um codigo de agencia foi digitado corretamente pelos operadores. Como o treinamento e voltado para fundamentos de Java, o objetivo e praticar leitura de entrada, comparacao de strings e decisoes condicionais.

Voce deve criar um programa que leia dois textos: o codigo informado pelo operador e o codigo esperado pelo sistema. Se os dois textos forem exatamente iguais, o programa deve indicar que a validacao foi aprovada. Caso contrario, deve informar que houve erro de digitacao. A comparacao deve considerar todos os caracteres exatamente como foram recebidos, incluindo letras maiusculas, minusculas, numeros e simbolos. Nao ha necessidade de tratar espacos extras fora do que for lido como entrada. O problema possui um unico objetivo: decidir se os dois codigos sao identicos ou nao.

Entrada
A entrada contem duas linhas. A primeira linha possui o codigo informado pelo operador. A segunda linha possui o codigo esperado pelo sistema. Cada linha deve ser tratada como uma string completa.

Saída
Exiba uma unica linha. Se os codigos forem exatamente iguais, imprima ACESSO LIBERADO. Caso contrario, imprima ACESSO NEGADO.

Exemplos
A tabela abaixo apresenta exemplos de entrada e saída:

Entrada	                Saída
AG123 AG123	        ACESSO LIBERADO
AG123 AG124	        ACESSO NEGADO
banco01 BANCO01	    ACESSO NEGADO
#CX9 #CX9	        ACESSO LIBERADO
*/

import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Codigo informado: ");
        String codigoInformado = scanner.next();
        System.out.println("Codigo esperado: ");
        String codigoEsperado = scanner.next();

        String status = codigoInformado.equals(codigoEsperado) ? "ACESSO LIBERADO" : "ACESSO NEGADO";

        System.out.println(status);

        scanner.close();
    }
}
