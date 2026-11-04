package Exercicio02;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CarroEntity {
    private String codigo;
    private String modelo;
    private String cor;
    private int velocidade;
    private CarroSeta seta;
    private int marcha;
    private CarroStatus status;
    private CarroPedais pedal;

    public CarroEntity() {

    }

    public CarroEntity(String modelo, String cor) {
        this.codigo = "CAR-" + new Random().nextInt(100);
        this.modelo = modelo;
        this.cor = cor;
        this.velocidade = 0;
        this.seta = CarroSeta.DESLIGADO;
        this.marcha = 0;
        this.status = CarroStatus.DESLIGADO;
        this.pedal = CarroPedais.FREIO;
    }

    public void ligar() {
        if (this.status == CarroStatus.LIGADO) {
            throw new RuntimeException("O carro já está ligado!");
        }

        this.status = CarroStatus.LIGADO;
    }

    public void trocarMarcha(String opcao) {
        if (this.status == CarroStatus.DESLIGADO) {
            throw new RuntimeException("O carro está desligado! Ligue o carro antes de trocar a marcha.");
        }

        if ("+".equals(opcao)) {
            if (this.marcha >= 6) {
                throw new IllegalStateException("Marcha máxima (6) já atingida! Não é possível aumentar.");
            }
            this.marcha++;

        } else if ("-".equals(opcao)) {
            if (this.marcha <= 0) {
                throw new IllegalStateException(
                        "O carro já está no ponto morto! Não é possível reduzir.");
            }
            this.marcha--;

        } else {
            throw new IllegalArgumentException("Opção de marcha inválida! Use '+' para aumentar ou '-' para reduzir.");
        }

    }

    public void acelerar() {
        if (this.status == CarroStatus.DESLIGADO) {
            throw new RuntimeException("O carro está desligado! Ligue o carro antes de acelerar.");
        }

        if (this.marcha == 0) {
            throw new IllegalStateException("Marcha em ponto morto! Engate uma marcha antes de acelerar.");
        }

        int limiteMaximo = this.marcha * 20;
        if (this.velocidade >= limiteMaximo) {
            throw new IllegalStateException(
                    "Limite atingido (" + limiteMaximo + "km/h)! Troque a marcha para continuar acelerando.");
        }

        this.velocidade++;

    }

    public void diminuirVelocidade() {
        if (this.status == CarroStatus.DESLIGADO) {
            throw new IllegalStateException("O carro está desligado.");
        }

        int limitMinimo = this.marcha == 1 ? 0 : (this.marcha - 1) * 20 + 1;

        if (this.velocidade <= limitMinimo) {
            throw new IllegalStateException("Velocidade mínima atingida para a " + this.marcha + "ª marcha.");
        }
        this.velocidade--;
    }

    public void desligar() {
        if (this.status == CarroStatus.DESLIGADO) {
            throw new RuntimeException("O carro já está desligado!");
        }

        if (this.marcha != 0 || this.velocidade != 0) {
            throw new RuntimeException(
                    "O carro não pode ser desligado se não estiver em ponto morto e com velocidade zero.");
        }
        this.status = CarroStatus.DESLIGADO;

    }

    public void virarEsquerdaOuDireita(String opcao) {
        if (this.status == CarroStatus.DESLIGADO) {
            throw new RuntimeException("Carro esta desligado.");
        }

        if (this.seta == CarroSeta.DIREITA || this.seta == CarroSeta.ESQUERDA) {
            throw new RuntimeException("Seta já está liagada.");
        }
        
        if ("d".equalsIgnoreCase(opcao)) {
            virarDireita();
        } else if ("e".equalsIgnoreCase(opcao)) {
            virarEsquerda();
        } else {
            System.out.println("opcão não existe.");
        }
    }

    public void virarEsquerda() {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        validarEstadoParaCurva();

        if (this.seta != CarroSeta.DESLIGADO) {
            throw new RuntimeException("A seta para esquerda já está ligada.");
        }

        this.seta = CarroSeta.ESQUERDA;

        if (this.seta == CarroSeta.ESQUERDA) {
            scheduler.schedule(() -> {
                this.seta = CarroSeta.DESLIGADO;
                scheduler.shutdown();

            }, 30, TimeUnit.SECONDS);
        }
    }

    public void virarDireita() {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        validarEstadoParaCurva();

        if (this.seta != CarroSeta.DESLIGADO) {
            throw new RuntimeException("A seta para direita já está ligada.");
        }

        this.seta = CarroSeta.DIREITA;

        if (this.seta == CarroSeta.ESQUERDA) {
            scheduler.schedule(() -> {
                this.seta = CarroSeta.DESLIGADO;
                scheduler.shutdown();

            }, 30, TimeUnit.SECONDS);
        }
    }

    private void validarEstadoParaCurva() {
        if (this.status == CarroStatus.DESLIGADO) {
            throw new RuntimeException("O carro está desligado!");
        }

        if (this.velocidade < 1 || this.velocidade > 40) {
            throw new RuntimeException("O carro só pode realizar curvas se a velocidade estiver entre 1km/h e 40km/h!");
        }

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public CarroSeta getSeta() {
        return seta;
    }

    public void setSeta(CarroSeta seta) {
        this.seta = seta;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public CarroStatus getStatus() {
        return status;
    }

    public void setStatus(CarroStatus status) {
        this.status = status;
    }

    public CarroPedais getPedal() {
        return pedal;
    }

    public void setPedal(CarroPedais pedal) {
        this.pedal = pedal;
    }

}
