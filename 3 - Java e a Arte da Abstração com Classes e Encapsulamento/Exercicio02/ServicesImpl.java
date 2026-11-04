package Exercicio02;

import java.util.Scanner;

public class ServicesImpl implements Services {

    private final static Scanner scanner = new Scanner(System.in);
    private final BancoEmMemoria banco;

    public ServicesImpl(BancoEmMemoria banco) {
        this.banco = banco;
    }

    @Override
    public void criarCarro() {
        System.out.println("=== OPÇÃO: CRIAR CARRO ===");
        System.out.println("Modelo: ");
        String modelo = scanner.next().toUpperCase();
        System.out.println("Cor: ");
        String cor = scanner.next().toUpperCase();
        System.out.println("=====================================================");

        CarroEntity carro = new CarroEntity(modelo, cor);
        CarroEntity carroSalvo = banco.salvar(carro);

        System.out.printf(">> Carro criado com sucesso - Modelo: %s | Cor: %s | CODIGO: %s\n",
                carroSalvo.getModelo(), carroSalvo.getCor(), carroSalvo.getCodigo());
        System.out.println("=====================================================");
    }

    @Override
    public void ligarCarro() {
        System.out.println("=== OPÇÃO: LIGAR CARRO ===");
        CarroEntity carro = buscarCarroPorCodigo();

        if (carro == null)
            return;

        try {
            carro.ligar();
            System.out.println("Carro ligado com sucess!");
            System.out.printf("Status do carro: %s \n", carro.getStatus());
        } catch (IllegalStateException e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    @Override
    public void trocarMarcha() {
        System.out.println("=== OPÇÃO: TROCAR MARCHA ===");
        CarroEntity carro = buscarCarroPorCodigo();

        if (carro == null)
            return;

        try {
            System.out.println("Digite + [Aumentar marcha] ou - [Reduzir]: ");
            String opcao = scanner.next();
            carro.trocarMarcha(opcao);
            System.out.println(">> Marcha trocada com sucesso!");
            System.out.printf(">> Marcha atual: %d marcha.\n", carro.getMarcha());
        } catch (IllegalStateException e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    @Override
    public void acelerar() {
        System.out.println("=== OPÇÃO: ACELERAR ===");
        CarroEntity carro = buscarCarroPorCodigo();

        if (carro == null)
            return;

        try {
            carro.acelerar();
            System.out.println(">> Acelerando esse trem doido...");
            System.out.printf(">> Velocidade atual: %d km/h | Marcha: %d\n", carro.getVelocidade(), carro.getMarcha());
        } catch (IllegalStateException e) {
            System.out.println(">> Erro: " + e.getMessage());
        }
    }

    @Override
    public void verificarVelocidade() {
        System.out.println("=== OPÇÃO: VERIFICAR VELOCIDADE ===");
        CarroEntity carro = buscarCarroPorCodigo();

        if (carro == null)
            return;

        System.out.printf(">> Velocidade atual: %d km/h\n", carro.getVelocidade());
    }

    @Override
    public void diminuirVelocidade() {
        System.out.println("=== OPÇÃO: DIMINUIR VELOCIDADE ===");
        CarroEntity carro = buscarCarroPorCodigo();

        if (carro == null)
            return;

        try {
            carro.diminuirVelocidade();
            System.out.println(">> Velocidade diminuída com sucesso!");
            System.out.printf(">> Velocidade atual: %d km/h\n", carro.getVelocidade());
        } catch (IllegalStateException e) {
            System.out.println(">> Erro: " + e.getMessage());
        }

    }

    @Override
    public void virarEsquerdaOuDireita() {
        System.out.println("=== OPÇÃO: VIRAR ESQUERDA/DIREITA ===");
        CarroEntity carro = buscarCarroPorCodigo();

        if (carro == null)
            return;

        System.out.println("Escolha E [esqurda] ou D [direita]: ");
        String opcao = scanner.next();

        try {
            carro.virarEsquerdaOuDireita(opcao);
            System.out.printf(">> O carro virou: %s com sucesso.", carro.getSeta());
        } catch (RuntimeException e) {
            System.out.println(">> Erro: " + e.getMessage());
        }

    }

    @Override
    public void desligarCarro() {
        System.out.println("=== OPÇÃO: DESLIGAR CARRO ===");
        CarroEntity carro = buscarCarroPorCodigo();

        if (carro == null)
            return;

        try {
            carro.desligar();
            System.out.println("Carro Desligado com sucesso!");
            System.out.printf("Status do carro: %s \n", carro.getStatus());
        } catch (RuntimeException e) {
            System.out.println(">> Erro: " + e.getMessage());
        }

    }

    private CarroEntity buscarCarroPorCodigo() {
        System.out.println("Digite o código do carro: ");
        String codigo = scanner.next();
        System.out.println("=====================================================");
        CarroEntity carro = this.banco.buscar(codigo);

        if (carro == null) {
            System.out.println(">> Erro: Carro não encontrado!");
        } else {
            System.out.printf(">> Encontrado carro com código: %s\n", carro.getCodigo());
        }
        return carro;
    }
}
