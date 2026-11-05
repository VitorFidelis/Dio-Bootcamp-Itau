public class Email implements NotificationService {

    @Override
    public void send(MarketingContex marketingContex) {
        System.out.println("EMAIL: Mensagem enviada com sucesso. 📨");
    }

}
