import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static boolean partida = true;
    private final static Scanner input = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {

        while (partida) {
            System.out.println("=== BILHETERIA: INGRESSOS PARA FILMES ===");
            System.out.println("1. INGRESSO: MEIA ENTRADA");
            System.out.println("2. INGRESSO: FAMILIA");
            System.out.println("0. EXIT");
            System.out.println("=============================");
            System.out.println("Informe a Opção de [1 a 0]: ");
            if (!input.hasNextInt()) {
                System.out.println("==========");
                System.out.println(">> Por favor, digite um número válido.");
                System.out.println("==========\n");
                input.nextLine();
                continue;
            }
            int opcao = input.nextInt();
            switch (opcao) {
                case 1 -> meiaEntrada();
                case 2 -> ingressoFamilia();
                case 0 -> {
                    partida = false;
                    break;
                }
                default -> System.out.println(">> Opção inválida! Tente novamente.\n");
            }

        }

    }

    private static void meiaEntrada() {
        System.out.println("=== OPÇÃO: MEIA ENTRADA ===");

        System.out.println("VALOR: ");
        double valorDoFilme = validacaoCamposDouble(input);

        input.nextLine();

        System.out.println("NOME DO FILME: ");
        String nomeDoFilme = validacaoCamposString(input);

        DisplayMode display = lerDisplayMode();

        Ingresso meiaEntradaIngresso = new MeiaEntrada(valorDoFilme, nomeDoFilme, display);

        System.out.println(">> Ingresso gerado com sucesso!");
        imprimirResumo(meiaEntradaIngresso);
    }

    private static void ingressoFamilia() {
        System.out.println("=== OPÇÃO: FAMILIA ===");

        System.out.println("VALOR: ");
        double valorDoFilme = validacaoCamposDouble(input);

        input.nextLine();

        System.out.println("NOME DO FILME: ");
        String nomeDoFilme = validacaoCamposString(input);

        DisplayMode display = lerDisplayMode();

        System.out.println("QUANTIDADE DE PESSOAS: ");
        int quantidadePessoas = validacaoCamposInt(input);

        Ingresso ingressoFamilia = new Familia(valorDoFilme, nomeDoFilme, display, quantidadePessoas);

        System.out.println(">> Ingresso gerado com sucesso!");
        imprimirResumo(ingressoFamilia);
    }

    private static DisplayMode lerDisplayMode() {
        System.out.println("LEGENDADO OU DUBLADO: ");
        String displayModeInput = input.next().toUpperCase();

        if ("LEGENDADO".equals(displayModeInput) || "LEG".equals(displayModeInput)) {
            return DisplayMode.LEGENDADO;
        }
        return DisplayMode.DUBLADO;
    }

    private static double validacaoCamposDouble(Scanner input) {
        while (!input.hasNextDouble()) {
            String entradaInvalida = input.next();
            System.out.printf(">> Error: \"%s\" não é um número válido \n", entradaInvalida);
            System.out.print("Tente novamente: ");
        }
        double valor = input.nextDouble();
        return valor;
    }

    private static int validacaoCamposInt(Scanner input) {
        while (!input.hasNextInt()) {
            String entradaInvalida = input.next();
            System.out.printf(">> Error: \"%s\" não é um número válido \n", entradaInvalida);
            System.out.print("Tente novamente: ");
        }
        int qtdPessoas = input.nextInt();
        return qtdPessoas;
    }

    private static String validacaoCamposString(Scanner input) {
        while (true) {
            String nomeFilme = input.nextLine().trim();

            if (!nomeFilme.isBlank() && nomeFilme.matches("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+$")) {
                return nomeFilme.toUpperCase();
            }

            System.out.println(">> Erro: Não são permitidos números/símbolos ou campo vazio.");
            System.out.print("Digite novamente: ");
        }
    }

    private static void imprimirResumo(Ingresso ingresso) {
        System.out.printf(
                "VALOR BASE: %.2f | NOME DO FILME: %s | MODO DE EXIBIÇÃO: %s | TOTAL DO INGRESSO: R$ %.2f \n\n",
                ingresso.getValor(),
                ingresso.getNomeDoFilme(),
                ingresso.getDisplayMode(),
                ingresso.valorDoIngresso());
    }

}
