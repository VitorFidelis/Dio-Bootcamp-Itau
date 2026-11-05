import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        List<NotificationService> channels = List.of(
                new Sms(),
                new Whatsapp(),
                new RedesSociais(),
                new Email());

        while (true) {
            System.out.println("\n=== ENVIO DE MENSAGEM DE MARKETING ===");

            System.out.println("Digite a mensagem: ");
            String mensagem = input.nextLine();

            System.out.println("Digite o nome do cliente: ");
            String nameClient = input.nextLine();

            System.out.println("Digite o email do cliente: ");
            String emailClient = input.next();

            System.out.println("Digite o telefone do ciente: ");
            String phoneClient = input.next();

            Costumer costumer = new Costumer(nameClient, emailClient, phoneClient);

            MarketingContex context = new MarketingContex(mensagem, costumer);

            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">> Disparando campanha para todos os canais...");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            channels.forEach(channel -> channel.send(context));

            String option = menuContinuar();

            if (!"S".equalsIgnoreCase(option)) {
                System.out.println("\n>> Markentig de hoje garantido!!!🚀");
                break;
            }

            input.nextLine();
        }

        input.close();
    }

    private static String menuContinuar() {
        String message = """
                \n=== OPÇÔES: CONTINUAR ===
                S -> PARA CONTINUAR;
                N -> PARA NÃO CONTINUAR;
                Deseja continuar: """;
        System.out.println(message);
        String option = input.next();
        return option;
    }
}
