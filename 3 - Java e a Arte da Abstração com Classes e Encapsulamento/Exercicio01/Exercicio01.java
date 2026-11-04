
/*
Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:

- Consultar saldo
- consultar cheque especial
- Depositar dinheiro;
- Sacar dinheiro;
- Pagar um boleto.
- Verificar se a conta está usando cheque especial.

Siga as seguintes regras para implementar:

- A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
- O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
- Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
- Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
- Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
*/
package Exercicio01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio01 {
    private final static Scanner input = new Scanner(System.in);
    private final static Map<Integer, Conta> bancoEmMemoria = new HashMap<>();
    private final static ContaMapper mapper = new ContaMapper();

    public static void main(String[] args) {
        Boolean teste = true;
        do {
            System.out.println("======== MENU ======== ");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("6 - Consultar cheque especial");
            System.out.println("7 - Verificar se a conta está usando cheque especial");
            System.out.println("0 - exit");
            System.out.println("========================");
            int opcao = opcaoEscolhida();
            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> consultarSaldo();
                case 3 -> depositarDinheiro();
                case 4 -> sacarDinheiro();
                case 5 -> pagarBoleto();
                case 6 -> consultarChequeEspecial();
                case 7 -> verificarContaChequeEspecial();
            }
            teste = opcao != 0;
        } while (teste);
    }

    private static int opcaoEscolhida() {
        System.out.println("Informe a opção: ");
        int opcao = input.nextInt();
        return opcao;
    }

    private static void criarConta() {
        System.out.println("\n=== CRIAÇÃO DA CONTA ===");
        System.out.println("Digite a agencia: ");
        int numeroAgencia = input.nextInt();
        System.out.println("Digite o numero da conta: ");
        int numeroConta = input.nextInt();
        System.out.println("Digite o saldo inicial: ");
        Double saldoIncial = input.nextDouble();
        System.out.println("==========================\n");
        double valorChequeEspecialGerado = geraChequeEspecial(saldoIncial);
        Conta contaCriada = new Conta(numeroAgencia, numeroConta, saldoIncial, valorChequeEspecialGerado);
        bancoEmMemoria.put(contaCriada.getNumeroConta(), contaCriada);
        ContaDTO teste = mapper.toDto(contaCriada);
        System.out.println(teste);
    }

    private static double geraChequeEspecial(Double valorSaldoConta) {
        double valorDoCheque;
        if (valorSaldoConta <= 500.00) {
            valorDoCheque = valorSaldoConta * 0.1;
        } else {
            valorDoCheque = valorSaldoConta * 0.5;
        }
        return valorDoCheque;
    }

    private static void consultarSaldo() {
        System.out.println("\n=== CONSULTAR SALDO  ===");
        System.out.println("Digite o numero da conta: ");
        int numeroConta = input.nextInt();
        System.out.println("\n======= SALDO =======");
        Conta contaEncontarda = bancoEmMemoria.get(numeroConta);

        if (contaEncontarda != null) {
            System.out.println("AVISO: Conta encontrada.");
            System.out.printf(">> Saldo atual da conta %d : %s\n", contaEncontarda.getNumeroConta(),
                    contaEncontarda.getSaldo());
        } else {
            System.out.println("AVISO: Nenhum Conta encontrado.\n");
        }
    }

    private static void depositarDinheiro() {
        System.out.println("\n=== DEPOSITAR DINHEIRO ===");
        System.out.println("Digite o numero da conta: ");
        int numeroConta = input.nextInt();
        System.out.println("==========================");
        Conta contaEncontarda = bancoEmMemoria.get(numeroConta);

        if (contaEncontarda != null) {
            System.out.println("AVISO: Conta encontrada.");
            System.out.println("Digite o valor a ser depositado: ");
            double valorDepositado = input.nextDouble();
            double valorContaAtual = contaEncontarda.getSaldo();
            double valorAtualizado = (valorContaAtual + valorDepositado);
            contaEncontarda.setSaldo(valorAtualizado);
            var contaAtualizada = bancoEmMemoria.put(contaEncontarda.getNumeroConta(), contaEncontarda);
            System.out.println("==========================");
            System.out.printf(">> SALDO ANTERIOR: %s | SALDO ATUAL: %s", valorContaAtual, contaAtualizada.getSaldo());
            System.out.println("\n");

        } else {
            System.out.println("AVISO: Nenhum Conta encontrado.\n");
        }
    }

    private static void sacarDinheiro() {
        System.out.println("\n=== SACAR DINHEIRO ===");
        System.out.println("Digite o numero da conta: ");
        int numeroConta = input.nextInt();
        System.out.println("==========================");
        Conta contaEncontarda = bancoEmMemoria.get(numeroConta);

        if (contaEncontarda != null) {
            System.out.println("AVISO: Conta encontrada.");
            System.out.println("Digite Valor a ser sacado: ");
            double valorSacado = input.nextDouble();
            double valorContaAtual = contaEncontarda.getSaldo();
            double valorAtualizado = (valorContaAtual - valorSacado);
            contaEncontarda.setSaldo(valorAtualizado);
            bancoEmMemoria.put(contaEncontarda.getNumeroConta(), contaEncontarda);
            Conta contaAtualizada = bancoEmMemoria.put(contaEncontarda.getNumeroConta(), contaEncontarda);
            System.out.println("==========================");
            System.out.printf(">> SALDO ANTERIOR: %s | SALDO ATUAL: %s", valorContaAtual, contaAtualizada.getSaldo());
            System.out.println("\n");

        } else {
            System.out.println("AVISO: Nenhum Conta encontrado.\n");
        }
    }

    private static void pagarBoleto() {
        System.out.println("\n==== PAGAR BOLETO ====");
        System.out.println("Informe o numero da conta: ");
        int numeroDaConta = input.nextInt();
        System.out.println("=====================");
        Conta contaEncontrada = bancoEmMemoria.get(numeroDaConta);

        if (contaEncontrada != null) {
            System.out.println("AVISO: Conta encontrada.");
            System.out.println("Informe o numero do boleto: ");
            var numeroDoBoleto = input.nextBigInteger();
            System.out.println("Informe o valor do boleto: ");
            double valorDoBoleto = input.nextDouble();
            double saldoAtualConta = contaEncontrada.getSaldo();
            double valorDoSaldoAtualizado = (saldoAtualConta - valorDoBoleto);
            contaEncontrada.setSaldo(valorDoSaldoAtualizado);
            bancoEmMemoria.put(contaEncontrada.getNumeroConta(), contaEncontrada);
            System.out.println("==========================");
            System.out.printf(">> SALDO ANTERIOR: %s | VALOR DO BOLETO: %s | SALDO ATUAL: %s", saldoAtualConta,
                    valorDoBoleto, valorDoSaldoAtualizado);
            System.out.println("\n");

        } else {
            System.out.println("AVISO: Nenhum Conta encontrado.\n");
        }
    }

    private static void consultarChequeEspecial() {
        System.out.println("\n=== CONSULTAR VALOR DO CHEQUE ESPECIAL ===");
        System.out.println("Informe o numero da conta: ");
        int numeroDaConta = input.nextInt();
        System.out.println("==========================================");
        Conta contaEncontrada = bancoEmMemoria.get(numeroDaConta);

        if (contaEncontrada != null) {
            System.out.println("AVISO: Conta encontrada.");
            double valorDoCheque = contaEncontrada.getChequeEspecial();
            System.out.printf(">> CONTA: %d | VALOR DO CHEQUE ESPECIAL: %s", contaEncontrada.getNumeroConta(),
                    valorDoCheque);
            System.out.println("\n");

        } else {
            System.out.println("AVISO: Nenhum Conta encontrado.\n");
        }
    }

    private static void verificarContaChequeEspecial() {
        System.out.println("\n=== Verificar se a conta está usando cheque especial ===");
        System.out.println("Informe o numero da conta: ");
        var numeroDaCOnta = input.nextInt();
        System.err.println("========================================================");
        Conta contaEncontrada = bancoEmMemoria.get(numeroDaCOnta);

        if (contaEncontrada != null) {
            System.out.println("AVISO: Conta encontrada.");
            Boolean status = contaEncontrada.getChequeEspecial() != 0.00;
            System.out.printf(">> STATUS RETORNADO: %s", status);
            System.out.println("\n");

        } else {
            System.out.println("AVISO: Nenhum Conta encontrado.\n");
        }
    }
}
